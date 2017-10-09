package com.cyt.music.interfaces.pojo.Pv;

import java.util.ArrayList;
import java.util.List;

public class PvInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PvInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andMainPageCountIsNull() {
            addCriterion("main_page_count is null");
            return (Criteria) this;
        }

        public Criteria andMainPageCountIsNotNull() {
            addCriterion("main_page_count is not null");
            return (Criteria) this;
        }

        public Criteria andMainPageCountEqualTo(Integer value) {
            addCriterion("main_page_count =", value, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountNotEqualTo(Integer value) {
            addCriterion("main_page_count <>", value, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountGreaterThan(Integer value) {
            addCriterion("main_page_count >", value, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_page_count >=", value, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountLessThan(Integer value) {
            addCriterion("main_page_count <", value, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountLessThanOrEqualTo(Integer value) {
            addCriterion("main_page_count <=", value, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountIn(List<Integer> values) {
            addCriterion("main_page_count in", values, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountNotIn(List<Integer> values) {
            addCriterion("main_page_count not in", values, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountBetween(Integer value1, Integer value2) {
            addCriterion("main_page_count between", value1, value2, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andMainPageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("main_page_count not between", value1, value2, "mainPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountIsNull() {
            addCriterion("contact_page_count is null");
            return (Criteria) this;
        }

        public Criteria andContactPageCountIsNotNull() {
            addCriterion("contact_page_count is not null");
            return (Criteria) this;
        }

        public Criteria andContactPageCountEqualTo(Integer value) {
            addCriterion("contact_page_count =", value, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountNotEqualTo(Integer value) {
            addCriterion("contact_page_count <>", value, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountGreaterThan(Integer value) {
            addCriterion("contact_page_count >", value, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_page_count >=", value, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountLessThan(Integer value) {
            addCriterion("contact_page_count <", value, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountLessThanOrEqualTo(Integer value) {
            addCriterion("contact_page_count <=", value, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountIn(List<Integer> values) {
            addCriterion("contact_page_count in", values, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountNotIn(List<Integer> values) {
            addCriterion("contact_page_count not in", values, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountBetween(Integer value1, Integer value2) {
            addCriterion("contact_page_count between", value1, value2, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andContactPageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_page_count not between", value1, value2, "contactPageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountIsNull() {
            addCriterion("more_page_count is null");
            return (Criteria) this;
        }

        public Criteria andMorePageCountIsNotNull() {
            addCriterion("more_page_count is not null");
            return (Criteria) this;
        }

        public Criteria andMorePageCountEqualTo(Integer value) {
            addCriterion("more_page_count =", value, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountNotEqualTo(Integer value) {
            addCriterion("more_page_count <>", value, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountGreaterThan(Integer value) {
            addCriterion("more_page_count >", value, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("more_page_count >=", value, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountLessThan(Integer value) {
            addCriterion("more_page_count <", value, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountLessThanOrEqualTo(Integer value) {
            addCriterion("more_page_count <=", value, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountIn(List<Integer> values) {
            addCriterion("more_page_count in", values, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountNotIn(List<Integer> values) {
            addCriterion("more_page_count not in", values, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountBetween(Integer value1, Integer value2) {
            addCriterion("more_page_count between", value1, value2, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andMorePageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("more_page_count not between", value1, value2, "morePageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountIsNull() {
            addCriterion("pay_page_count is null");
            return (Criteria) this;
        }

        public Criteria andPayPageCountIsNotNull() {
            addCriterion("pay_page_count is not null");
            return (Criteria) this;
        }

        public Criteria andPayPageCountEqualTo(Integer value) {
            addCriterion("pay_page_count =", value, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountNotEqualTo(Integer value) {
            addCriterion("pay_page_count <>", value, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountGreaterThan(Integer value) {
            addCriterion("pay_page_count >", value, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_page_count >=", value, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountLessThan(Integer value) {
            addCriterion("pay_page_count <", value, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountLessThanOrEqualTo(Integer value) {
            addCriterion("pay_page_count <=", value, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountIn(List<Integer> values) {
            addCriterion("pay_page_count in", values, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountNotIn(List<Integer> values) {
            addCriterion("pay_page_count not in", values, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountBetween(Integer value1, Integer value2) {
            addCriterion("pay_page_count between", value1, value2, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andPayPageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_page_count not between", value1, value2, "payPageCount");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}