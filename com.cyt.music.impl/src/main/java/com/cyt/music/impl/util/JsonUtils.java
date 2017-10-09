package com.cyt.music.impl.util;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonUtils {

	// private static Logger log = Logger.getLogger(JsonUtils.class);
	// 判断是否是json
	public static boolean isJson(String s) {
		if (s != null && s.startsWith("{") && s.endsWith("}")) {
			return true;
		}
		return false;
	}

	public static boolean isSucJson(String s) {
		if (!isJson(s)) {
			return false;
		}
		JSONObject json = JSONObject.fromObject(s);
		if (json.getString("returnCode").equals("9999")) { // api接口系统异常
			return false;
		}
		return true;
	}

	public static JSONArray getJsonArray(JSONObject o, String name) {
		if (o == null || name == null || name.equals("")) {
			return new JSONArray();
		}
		if (o.containsKey(name)) {
			return o.getJSONArray(name);
		}
		return new JSONArray();
	}

	public static String getString(JSONObject o, String name) {
		if (null == o || null == name) {
			return null;
		}
		if (o.containsKey(name)) {
			return o.getString(name);
		}
		return null;
	}

	public static String getJsonString(JSONObject o, String str) {
		if (null != o && o.has(str)) {
			return o.get(str).toString();
		}
		return "";
	}

	/**
	 * json字符串转成Map对象
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static Map<String, Object> jsonStrToMap(String str) {
		JSONObject obj = null;
		if (isJson(str)) {
			obj = JSONObject.fromObject(str);
			return jsonToMap(obj);
		}
		return new HashMap<String, Object>();
	}

	/**
	 * json字符串转成JSONObject对象
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static JSONObject jsonStrToJsonObj(String str) {
		JSONObject obj = null;
		if (isJson(str)) {
			obj = JSONObject.fromObject(str);
		}
		return obj;
	}

	/**
	 * 将json字符串转换成Map
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(JSONObject jsonObject) {
		// 结果对象
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// check参数
		if (null == jsonObject) {
			return resultMap;
		}
		setDataFormat2JAVA();
		Iterator<String> iterator = jsonObject.keys();
		String key = "";
		String value = "";
		while (iterator.hasNext()) {
			// 取得key值
			key = iterator.next();
			// 取得value值
			value = jsonObject.getString(key);
			// 如果value值为空, 处理下一个
			if (!StringUtil.isNotEmptyStr(value)) {
				continue;
			}
			// 将key转换为Java驼峰方式
			key = StringUtil.convertField(key);
			// 字符串同时包含 "Date("和 "+0800)", 则为日期类型
			if (StringUtils.contains(value, "Date(") && StringUtils.contains(value, "+0800)")) {
				// 取出该日期中的毫秒数
				value = value.replace("Date(", "").replace("+0800)", "").replace("/", "").replace("\\", "");
				// 保存该日期
				resultMap.put(key, new Date(Long.valueOf(value)));
				continue;
			}
			// 保存数据
			resultMap.put(key, value);
		}
		return resultMap;
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 *           json字符串
	 * @param pojoCalss
	 *           java对象的class
	 * @return
	 */
	public static Object getObject4JsonString(String jsonString, Class<?> pojoCalss) {
		// check参数
		if (!StringUtil.isNotEmptyStr(jsonString)) {
			return null;
		}
		setDataFormat2JAVA();
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		if (null == jsonObject) {
			return null;
		}
		return JSONObject.toBean(jsonObject, pojoCalss);
	}

	/**
	 * 将Json的key转换为Java命名的驼峰标识
	 * 
	 * @param jsonString
	 * @return Java驼峰标识的Json
	 */
	public static String formatJsonKey(String jsonString) {
		// check参数
		if (!StringUtil.isNotEmptyStr(jsonString)) {
			return "";
		}
		// 先读取串数组
		setDataFormat2JAVA();
		JSONArray array = JSONArray.fromObject(jsonString);
		// 转成对像数组
		Object[] objects = array.toArray();
		if ((null == objects) || (0 == objects.length)) {
			return "";
		}
		// 临时数组
		String[] tmpArray1 = null;
		String[] tmpArray2 = null;
		String[] tmpArray3 = null;
		String tmpData1 = "";
		String tmpData2 = "";
		String tmpKey = "";
		String tmpValue = "";
		int length = 0;
		// 转换新Json
		StringBuffer newJson = new StringBuffer("[");
		for (Object object : objects) {
			newJson.append("{");
			// 转化为String对象
			tmpData1 = object.toString();
			// 去掉json的{}
			tmpData1 = tmpData1.replace("{", "").replace("}", "");
			//System.out.println("tmpData1 := " + tmpData1);
			tmpArray1 = StringUtils.split(tmpData1, ",");
			if ((null != tmpArray1) && (0 != tmpArray1.length)) {
				for (String data : tmpArray1) {
					tmpArray2 = data.split(":");
					tmpKey = tmpArray2[0];
					tmpValue = tmpArray2[1];
					if (!StringUtil.isNotEmptyStr(tmpKey)) {
						continue;
					}
					// 将tmpKey转换Java驼峰标识
					tmpKey = tmpKey.toLowerCase();
					tmpArray3 = tmpKey.split("_");
					if ((null == tmpArray3) || (0 == tmpArray3.length)) {
						continue;
					}
					length = tmpArray3.length;
					if (1 == length) {
						newJson.append(tmpArray3[0]).append(":\"");
						newJson.append(tmpValue).append("\",");
					} else {
						newJson.append(tmpArray3[0]);
						for (int index = 1; index < length; index++) {
							tmpData2 = tmpArray3[index].replace("\"", "");
							char beginOld = tmpData2.charAt(0);
							char beginNew = (beginOld + "").toUpperCase().charAt(0);
							tmpData2 = tmpData2.replace(beginOld, beginNew);
							newJson.append(tmpData2);
						}
						newJson.append("\":").append(tmpValue);
					}
				}
			}
			newJson.append("},");
		}
		int lastIndex = newJson.lastIndexOf(",");
		newJson.replace(lastIndex, newJson.length(), "");
		newJson.append("]");
		return newJson.toString();
	}

	/**
	 * Json字符串中日期格式转换
	 */
	private static void setDataFormat2JAVA() {
		// 设定日期转换格式
		JSONUtils.getMorpherRegistry().registerMorpher(
		      new DateMorpher(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" }));
	}

	/**
	 * 将Json对象转换为Java对象
	 * 
	 * @param <T>
	 * @param jsonObject
	 * @param cla
	 * @return
	 */
	public static <T> T convertToObj(JSONObject jsonObject, Class<T> cla) {
		if (null == jsonObject)
			return null;
		Field[] fields = cla.getDeclaredFields();
		T t;
		try {
			t = cla.newInstance();
			for (Field field : fields) {
				String fieldName = field.getName();
				String fieldNameU = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				Method[] methods = cla.getMethods();
				for (Method method : methods) {
					if (method.getName().endsWith("set" + fieldNameU)) {
						method = cla.getMethod("set" + fieldNameU, field.getType());
						if (jsonObject.get(fieldName) != null) {
							String jsonObjectStr = jsonObject.get(fieldName).toString().trim();
							if (field.getType() == String.class) {
								method.invoke(t, !StringUtil.isNotEmptyStr(jsonObjectStr) ? null : jsonObjectStr);
							}
							if (field.getType() == Double.class) {
								method.invoke(t,
								      !StringUtil.isNotEmptyStr(jsonObjectStr) ? null : Double.valueOf(jsonObjectStr));
							}
							if (field.getType() == Integer.class) {
								method.invoke(t,
								      !StringUtil.isNotEmptyStr(jsonObjectStr) ? null : Integer.valueOf(jsonObjectStr));
							}
							if (field.getType() == Long.class) {
								method.invoke(t, !StringUtil.isNotEmptyStr(jsonObjectStr) ? null : Long.valueOf(jsonObjectStr));
							}
							if (field.getType() == Date.class) {
								if (jsonObjectStr.length() == 21) {
									jsonObjectStr = jsonObjectStr.substring(0, jsonObjectStr.length() - 2);
								}
								method.invoke(
								      t,
								      !StringUtil.isNotEmptyStr(jsonObjectStr) ? null : DateUtil.parseDate(jsonObjectStr,
								            "yyyy-MM-dd HH:mm:ss"));
							}
						}
					}
				}
			}
			return t;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将Json转换为实体对象Entity
	 * 
	 * @param <T>
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> T convertJsonToEntity(JSONObject jsonObject, Class<T> clazz) throws Exception {
		// check
		if ((null == jsonObject) || (null == clazz)) {
			return null;
		}
		// 取得字段属性集合
		Field[] fields = clazz.getSuperclass().getDeclaredFields();
		if ((null == fields) || (0 == fields.length)) {
			return null;
		}
		/** 临时变量 */
		// 属性名
		String propertyName = "";
		String fieldNameU = "";
		// 属性值
		Object propertyValue = null;
		String fieldName = "";
		String fieldValue = "";
		// 方法对象
		Method method = null;
		// 参数值
		Object paramterValue = null;
		// 参数类型
		Type type = null;
		// 取得json对象中的key列表
		Iterator<String> iterator = jsonObject.keys();
		try {
			// 实例化
			T t = clazz.newInstance();
			// 遍历jason对象的key列表
			while (iterator.hasNext()) {
				// 属性名
				propertyName = iterator.next();
				// check jsonKey
				if (StringUtil.isNull(propertyName) || StringUtil.isEmpty(propertyName)) {
					continue;
				}
				// 属性值
				propertyValue = jsonObject.get(propertyName);
				// check属性值, 如果为空处理下一个属性
				if (null == propertyValue) {
					continue;
				}
				// check
				if (propertyValue instanceof String) {
					// check属性值是否为null, ""
					if (!StringUtil.isNotEmptyStr(propertyValue.toString())) {
						continue;
					}
					// check属性值去掉前后空格后, 是否为null, ""
					if (!StringUtil.isNotEmptyStr(propertyValue.toString().trim())) {
						continue;
					}
				}
				// 将数据库表字段字符串转换为驼峰标识字符串
				propertyName = StringUtil.convertField(propertyName);
				// 遍历字段属性数组
				for (Field field : fields) {
					// 字段名
					fieldName = field.getName();
					// 参数类型
					type = field.getType();
					// 属性名匹配
					if (!propertyName.equals(fieldName)) {
						continue;
					}
					// 将属性名的第一个字母大写
					fieldNameU = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
					// 取得该属性类型的set方法
					method = clazz.getMethod(fieldNameU, field.getType());
					// 下面代码都是参数类型是什么，如果有需求可以自行增加
					if (type == Long.class || type == long.class) { // 当set方法中的参数为long或者Long
						if (propertyValue instanceof Long) {
							paramterValue = propertyValue;
						} else {
							paramterValue = Long.parseLong(propertyValue.toString());
						}
					} else if (type == Integer.class || type == int.class) { // 当set方法中的参数为int或者Integer
						if (propertyValue instanceof Integer) {
							paramterValue = propertyValue;
						} else {
							paramterValue = Integer.parseInt(propertyValue.toString());
						}
					} else if ((type == Date.class) || (type == java.sql.Date.class)) { // 当set方法中的参数为Date
						if ((propertyValue instanceof Date) || (propertyValue instanceof java.sql.Date)) {
							paramterValue = propertyValue;
						} else {
							// 字段字符串值
							fieldValue = propertyValue.toString();
							// check属性是否为日期类型,
							// 字符串同时包含 "Date("和 "+0800)", 则为日期类型
							if (fieldValue.contains("Date(") && fieldValue.contains("+0800)")) {
								// 取出日期字符串中的毫秒数
								fieldValue = fieldValue.replace("/", "").replace("\\", "").replace("Date(", "")
								      .replace("+0800)", "");
								// 调用set方法保存值
								method.invoke(t, new java.util.Date(Long.valueOf(fieldValue)));
								break;
							}
						}
					} else if (type == double.class || type == Double.class) { // 当set方法中的参数为Double或double
						if (propertyValue instanceof Double) {
							paramterValue = propertyValue;
						} else {
							paramterValue = Double.parseDouble(propertyValue.toString());
						}
					} else if (type == float.class || type == Float.class) { // 当set方法中的参数为Float或float
						if (propertyValue instanceof Float) {
							paramterValue = propertyValue;
						} else {
							paramterValue = Float.parseFloat(propertyValue.toString());
						}
					} else if (type == Long.class) { // 当set方法中的参数为BigInteger
						if (propertyValue instanceof Long) {
							paramterValue = propertyValue;
						} else {
							paramterValue = Long.parseLong(propertyValue.toString());
						}
					} else if (type == BigDecimal.class) { // 当set方法中的参数为BigDecimal
						if (propertyValue instanceof BigDecimal) {
							paramterValue = propertyValue;
						} else {
							paramterValue = BigDecimal.valueOf(Long.valueOf(propertyValue.toString()));
						}
					} else if (type == boolean.class || type == Boolean.class) { // 当set方法中的参数为boolean或Boolean
						if (propertyValue instanceof Boolean) {
							paramterValue = propertyValue;
						} else {
							String tmpData = propertyValue.toString();
							if ("0".equals(tmpData) || ("false").equalsIgnoreCase(tmpData)) {
								paramterValue = false;
							} else if ("1".equals(tmpData) || ("true").equalsIgnoreCase(tmpData)) {
								paramterValue = true;
							}
							paramterValue = false;
						}
					} else if (type == String.class) { // 当set方法中的参数为其他
						paramterValue = propertyValue.toString();
					} else {
						paramterValue = propertyValue.toString();
					}
					// 执行set方法保存值
					method.invoke(t, paramterValue);
					break;
				}
			}
			return t;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			throw new SecurityException("[mapBind]安全异常：" + e);
		} catch (NoSuchMethodException e) {
			throw new NoSuchMethodException("[mapBind]Vo中无此方法异常" + e);
		} catch (IllegalArgumentException e) {
			throw new Exception("VO中属性类型与参数的类型不匹配");
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException("[mapBind]IllegalAccessException异常");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 参数值转换
	 * 
	 * @param type
	 * @param fieldValue
	 * @return
	 */
	public static Object getParameterValue(Type type, Object fieldValue) {
		// check
		if ((null == type) || (null == fieldValue)) {
			return null;
		}
		// 如果fieldValue是String
		if (fieldValue instanceof String) {
			if (StringUtil.isEmpty(fieldValue.toString().trim())) {
				return null;
			}
		}
		// 当set方法中的参数为Long和long类型
		if ((type == Long.class) || (type == long.class)) {
			if (fieldValue instanceof Long) {
				return fieldValue;
			} else {
				Long.parseLong(fieldValue.toString());
			}
		} else if ((type == Integer.class) || (type == int.class)) { // 当set方法中的参数为Integer和int类型
			if (fieldValue instanceof Long) {
				return fieldValue;
			} else {
				Integer.parseInt(fieldValue.toString());
			}
		} else if ((type == Date.class) || (type == java.sql.Date.class)) { // 当set方法中的参数为Date
			if ((fieldValue instanceof Date) || (fieldValue instanceof java.sql.Date)) {
				return fieldValue;
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					return sdf.parse(fieldValue.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}
		} else if ((type == Double.class) || (type == double.class)) { // 当set方法中的参数为Double或double
			if (fieldValue instanceof Double) {
				return fieldValue;
			} else {
				return Double.parseDouble(fieldValue.toString());
			}
		} else if ((type == Float.class) || (type == double.class)) { // 当set方法中的参数为Float或float
			if (fieldValue instanceof Float) {
				return fieldValue;
			} else {
				return Float.parseFloat(fieldValue.toString());
			}
		} else if (type == BigDecimal.class) { // 当set方法中的参数为BigDecimal
			if (fieldValue instanceof BigDecimal) {
				return fieldValue;
			} else {
				return BigDecimal.valueOf(Long.valueOf(fieldValue.toString()));
			}
		} else if (type == BigDecimal.class) { // 当set方法中的参数为BigDecimal
			if (fieldValue instanceof BigDecimal) {
				return fieldValue;
			} else {
				return BigDecimal.valueOf(Long.valueOf(fieldValue.toString()));
			}
		} else if (type == boolean.class || type == Boolean.class) { // 当set方法中的参数为boolean或Boolean
			if (fieldValue instanceof Boolean) {
				return fieldValue;
			} else {
				String tmpData = fieldValue.toString();
				if ("0".equals(tmpData) || ("false").equalsIgnoreCase(tmpData)) {
					return false;
				} else if ("1".equals(tmpData) || ("true").equalsIgnoreCase(tmpData)) {
					return true;
				}
				return false;
			}
		} else if (type == String.class) { // 当set方法中的参数为其他
			if (fieldValue instanceof String[]) {
				String[] tempArray = (String[]) fieldValue;
				String result = "";
				for (int m = 0; m < tempArray.length; m++) {
					result = result + tempArray[m] + ",";
				}
				result = result.substring(0, result.length() - 1);
				return result;
			} else {
				return fieldValue.toString();
			}
		}
		return fieldValue.toString();
	}

	/**
	 * javaBean转Map
	 * 
	 * @param bean
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> convertBean(Object bean) throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Class<?> type = bean.getClass();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					if (result instanceof Date) {
						returnMap.put(propertyName, DateUtil.formatDateYMDHMS((Date) result));
					} else {
						returnMap.put(propertyName, result.toString());
					}
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	/**
	 * javaBean转Map 日期不处理
	 * 
	 * @param bean
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> convertMap(Object bean) throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Class<?> type = bean.getClass();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					if (descriptor.getPropertyType() == String.class) {
						returnMap.put(propertyName, "");
					} else {
						returnMap.put(propertyName, result);
					}

				}
			}
		}
		return returnMap;
	}

	/**
	 * 优先转化为json对象，转化失败尝试转为json数组
	 * 
	 * @param obj
	 * @return
	 */
	public static String beanToJson(Object obj) {
		if (obj == null)
			return "";
		try {
			return JSONObject.fromObject(obj).toString();
		} catch (Exception e) {
			return JSONArray.fromObject(obj).toString();
		}

	}
}
