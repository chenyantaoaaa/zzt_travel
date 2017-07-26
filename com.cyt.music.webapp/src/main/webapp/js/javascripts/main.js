/**
 * main.js
 * @author shen
 * @create 2017-07-08 10:15
 */
//屏幕自适应
(function(doc,win){
    var resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';
    var recalc = function () {
        var clientWidth = $(doc).width();
        if (!clientWidth) return;
        $("html").css("font-size", 100*clientWidth / 1920+"%");
        $(".m-bg-slide ul li").css("width", clientWidth);
        $(".m-bg-slide").css("width", clientWidth);
    };
    $(win).on(resizeEvt,recalc);
    $(doc).on('DOMContentLoaded',recalc)
})(document,window);

(function () {
    $(".m-nav").on("click",function(e){
        e.preventDefault();
        $(".last").removeClass("last");
        $('.current').addClass("last");
        var id = $(e.target).attr("href");
        $(e.target).closest("li").addClass("active").siblings().removeClass("active");
        $(id).addClass("active").siblings().removeClass("active");
        var liWidth = $(".m-bg-slide").width();
        var times = Number( $(e.target).data("bg") );
        var t = setTimeout(function () {
            $(".m-bg-slide>ul li").eq($("ul.m-nav li").index($(e.target).closest("li"))).addClass("current").siblings().removeClass("current");
            clearTimeout(t)
        },1000)
    })
})();

(function () {
    $(".t-nav").on("click",function (e) {
        if(!e.target || $(e.target).hasClass("active")){
            return
        }else{
            $(e.target).closest(".t-nav").find("a").removeClass("active");
            $(e.target).addClass("active")
        }
    })
})();

$(".card-close-more").on("click",function(e){
    e.stopPropagation();
    $(e.target).closest(".m-hotel-body").find(".card-open-more").css("display","block");
    $(e.target).closest(".m-hotel-body").find(".card-close-more").css("display","none");
    $(e.target).closest(".m-hotel-body").find(".m-hotel-detail").css("display","none");
});

$(".card-open-more").on("click",function(e){
    e.stopPropagation();
    $(e.target).closest(".m-hotel-body").find(".card-close-more").css("display","block");
    $(e.target).closest(".m-hotel-body").find(".card-open-more").css("display","none");
    $(e.target).closest(".m-hotel-body").find(".m-hotel-detail").css("display","block");
});

$(function () {
    var views = {
        "hkzj":{
          title: "汉口租界",
          pics: ["../../img/images/viewpoints/1-2_573_353.png","../../img/images/viewpoints/1-3_277_346.png","../../img/images/viewpoints/1-4_277_346.png"],
          brief: [
              '汉口租界，是二战时期英国、俄国、法国、德国、日本和比利时租界的统称。20世纪初，汉口已经成为一个具有相当规模的国际大都市，被称为“东方芝加哥"',
              '汉口租界占地约186公顷。这一带至今还矗立着各国风格的旧式楼房，是西方列强与19世纪至20世纪初遗留的历史建筑。其中代表性建筑有武汉关、大智门火车站等。',
              '行走在汉口租界的1861年的建筑中，你仿佛依旧置身于欧洲。在任何一个角落你都能体会到这座魅力东方城市150年经久不衰的繁荣，以及那些旧时光的浪漫与风情。'
          ]
        },
        "ljyy":{
            title: "两江夜游",
            pics: ["../../img/images/viewpoints/2-2_573_353.png","../../img/images/viewpoints/2-3_573_346.png"],
            brief: [
                '长江作为江城的旅游名片，是游客来到武汉不可或缺的一站。乘坐游船行驶于江面上，可以将长江大桥、江滩、黄鹤楼等 两岸风光尽收眼底，夜游景色更佳。夜游长江是武汉非常出名的休闲项目，相比白日里的喧嚣热闹，武汉的夜晚温柔的多 。',
                '汉口的粤汉码头、武昌的红港码头和汉江旅游码头三个码头都有发船，部分班次的船上还提供中西餐、自助餐等服务，可 以一边欣赏烟头美景，一边享受美食。',
                '塞纳河新桥长238米，武汉长江大桥全场1670米。看腻了小河的浪漫与婉约，不妨来感受大河壮阔与洒脱。'
            ]
        },
        "tmhx":{
            title: "天门狐仙",
            pics: ["../../img/images/viewpoints/3-2_573_353.png","../../img/images/viewpoints/3-3_287_346.png","../../img/images/viewpoints/3-4_277_346.png"],
            brief: [
                '《天门狐仙》舞台剧故事取材于当地传说故事 ——',
                '相传狐狸之王选妃，选中了千年的白狐仙，可她却向往人间的生活，爱上贫穷快乐的樵夫刘海，两人在张家界天门山不期而遇，各种矛盾如同大山重重阻隔着两颗相爱的心。悲伤、快乐、笑容、泪水交合成一个曲折动人的故事。整场演出提现任务细节，以个性化的叙事结构给人以亲近感和头尾呼应的完整感。',
                '近一万平米剧场的漫天飞雪，狐狸精在舞台上直接变换成人型，超大可移动人造月亮，瞬间被流水包裹的5000平米玻璃钢炫彩舞台，60米长高空飞桥，一切尽在山水之间上演。'
            ]
        },
        "tjfqy":{
            title: "土家风情园",
            pics: ["../../img/images/viewpoints/4-2_573_353.png","../../img/images/viewpoints/4-3_573_346.png"],
            brief: [
                '风情园建筑多为木石结构，雕梁画栋，金碧辉煌，飞檐翘角，玲珑雅致。代表作有土司城堡、摆手堂、土家山寨等。特别是冲天楼，依山造阁，气势恢宏，楼高48米，九重十二层，曲径回复，独具匠心。',
                '民风民俗展示主要有土家婚俗，头饰服饰、蜡染、织锦、银匠、石匠以及奇石根雕，珍贵文物展等，还有整台原汁原味的土家文艺节目，如表现土家原始劳作与生活情形的茅古斯舞、铜铃舞、摆手舞、打溜子等表演。',
                '土家风情园对土家族近五千年的历史文化乃至农耕时代的原始劳作与生活情形进行了系统和全面的解读。'
            ]
        },
        "tzfjq":{
            title: "天子风景区",
            pics: ["../../img/images/viewpoints/5-2_573_353.png","../../img/images/viewpoints/5-3_217_346.png","../../img/images/viewpoints/5-4_337_346.png"],
            brief: [
                '天子山有云涛、月辉、霞日、冬雪四大奇观。山间云雾变幻无穷，仪态万千，时如江海翻波，涌涛逐浪，时若轻纱掩体， 缥缈虚无。日出时辉映长空，日落处霞光无限，又将天子山装点成瑰丽明艳的帝王宫阙。',
                '天子山还以石林奇观闻名遐迩。无数石峰如剑如戟，森然列于其间5，更似千军簇拥，气势雄浑无媲。览胜之间，令人遐 思无限，不得不惊叹造物者的鬼斧神工。',
                '乘坐天子山索道既舒适又看全，沿线风光奇艳，奇松怪石，莽莽翠林，令人叹为观止。尤其在云雾缭绕之时，游客乘坐索 道更能体验到神仙飘逸飞行的动感与刺激。'
            ]
        },
        "hld":{
            title: "黄龙洞",
            pics: ["../../img/images/viewpoints/6-2_573_353.png","../../img/images/viewpoints/6-3_277_346.png","../../img/images/viewpoints/6-4_277_346.png"],
            brief: [
                '黄龙洞是张家界景区的重要组成部分，地处核心景区，属典型的克斯特岩溶地貌，享有绝世奇观之美誉。黄龙洞现已开放 龙舞厅、天仙水、天柱街、龙宫、迷宫、花果山等游览区。',
                '黄龙洞现已探明的洞底总面积10万平方米，全场7.5公里，垂直高度140米。洞体共分四层，黄龙洞整个洞内洞中有洞，洞 中有河。石笋、石柱、石钟乳各种洞穴奇观琳琅满目，美不胜收。',
                '据考证大约3.8亿年前，黄龙洞地区是一篇汪洋，沉积了可溶性强的石灰岩和白云岩层，经过漫长的时间开始孕育洞穴， 然后经岩溶和水流作用，便形成了今日地下奇观。'
            ]
        },
        "yjjjq":{
            title: "袁家界风景区",
            pics: ["../../img/images/viewpoints/7-2_573_353.png","../../img/images/viewpoints/7-3_277_346.png","../../img/images/viewpoints/7-4_277_346.png"],
            brief: [
                '袁家界 风景区位于张家界国家森林公园北部，是一方山台地，背依岩峰山峦，面临幽谷群峰，自东向西延伸。主要景点 有后花园、迷魂台、天下第一桥等、是镶嵌在武陵源核心景区的一颗明珠。',
                '袁家界名称相传来源于后唐，反抗朝廷的将士为躲避追捕，便来到了这远离人世的深山野岭——青岩山隐居，他在这里结庐为舍，垦荒种粮，并以自己的姓氏为这里命名，起名“袁家界”。袁家界位于杉刀沟北麓，是以石英岩为主构成的一座大而比较平缓的山岳。',
                '电影《阿凡达》中的“哈利路亚山”原型“乾坤柱”就来自于袁家界。'
            ]
        },
        "fhgc":{
            title: "凤凰古城",
            pics: ["../../img/images/viewpoints/8-2_573_353.png","../../img/images/viewpoints/8-3_573_346.png"],
            brief: [
                '凤凰古城始建于1556年，至今已有四百多年历史，虽历经沧桑，仍保存完好，古风依旧。凤凰古城位于湖南省湘西自治州西南边，有一山酷似展翅而飞的凤凰，古城因此而得名。',
                '她的城市居民由苗族、汉族、土家族等28个民族组成，是典型的少数民族聚居区。曾被新西兰著名作家路易·艾黎称赞为中国最美丽的小城。',
                '古城内的青石板街道、江边木结构吊脚楼、众多古建筑，以及浓厚的苗族风情，构成了凤凰独具一格的味道。'
            ]
        },
    };
    $(".card-more-info").on("click",function (e) {
        e.stopPropagation();
        var viewPoint = $(this).data("title");
        views[viewPoint].pics.forEach(function (item,index) {
            var img = "<img src='"+ item +"'/>";
            $(".left-side").append(img)
        });
        views[viewPoint].brief.forEach(function (item,index) {
            var p = "<p>"+ item +"<p/>";
            $(".right-side section").append(p)
        });
        $(".right-side header").text(views[viewPoint].title);
        $("body").css("overflow","hidden");
        $(".modal-view-point").css("display","block");
    });
    $(".modal-close").on("click",function () {
        $("body").css("overflow","auto");
        $(".left-side").empty();
        $(".right-side section").empty();
        $(".right-side header").text("");
        $(".modal-view-point").css("display","none");
    })
})();