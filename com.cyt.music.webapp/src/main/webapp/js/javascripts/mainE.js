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
        var id = $(e.target).data("href") || $(e.target).attr("href");
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
        "tmhx":{
            title: "Tianmen mountain fairy fox perform",
            pics: ["../../../img/images/viewpoints/3-2_573_353.png","../../../img/images/viewpoints/3-3_287_346.png","../../../img/images/viewpoints/3-4_277_346.png"],
            brief: [
                "Tianmen fox drama show the real Oriental Fantasy style scene: nearly 10 thousand square meters of snow all over the sky, the fox theater directly changes adult type, large movable artificial moon, instant water parcels of 5000 square meters of glass steel colorful stage, 60 meters high altitude flying bridge, the protagonist up hundreds of meters altitude transform into the stars disappear on the stage on... The use of a large number of machinery, magic and special effects, create a scene of amazing fantasy scene, so that the audience stunned, incredible. As the story moves, the audience can even see the audience sobbing... The three enjoyment of vision, hearing and soul."
            ]
        },
        "tzfjq":{
            title: "Tianmen mountain",
            pics: ["../../../img/images/viewpoints/tms2.jpg","../../../img/images/viewpoints/6-3_277_346.png","../../../img/images/viewpoints/6-4_277_346.png"],
            brief: [
                "Tourists can ascend on the top of the Mount Tianman by taking the touring ropeway, and experience the excitement of flying over the clouds. They can feast their eyes with the panoramic viewing of Zhangjiajie, and experience the proud and freedom of standing at the highest peak. They can also take the smaller ropeway from the top of the peak to the Cherry Bay, flying over the trees and enjoying the natural garden in the air. The Mount Tianmen Temple shall take the tourists close to the Buddhism and experience the solemn of the Temple which has witnessed thousands years’ time. For tourists who like challenge and excitement, the west tourist route of Ghost Plank Road where they can scream heartily is a good choice. Lingxiao Platform (Platform over the Sky) is the place where the tourists can enjoy city scenery and the magnificent landscape. When they get to the Middle station of the ropeway, they can transfer to the sightseeing bus to experience the unique road with 99 turnings. The following destination is Tianmen Cave where the tourists can experience the unique heritage of the nature. Then they can take the sightseeing bus back to the Middle Station of the Ropeway and take the ropeway to return to the city."
            ]
        },
        "hld":{
            title: "Huanglong Cave.",
            pics: ["../../../img/images/viewpoints/7-2_573_353.png","../../../img/images/viewpoints/7-3_277_346.png","../../../img/images/viewpoints/7-4_277_346.png"],
            brief: [
                "Huanglong Cave covers an area of 20 hectares. It contains four layers with the total vertical height of more than one hundred meters. There are one cave, two rivers, three waterfalls, four pools, thirteen halls, forty-six verandas, and numerous Stalagmites, stone columns, stone curtains, stone flowers and stone waterfalls in it. The most amazing stalactites are the Magic Sea-suppressing Needle and the Dragon King’s Throne. The height of the Magic Sea-suppressing Needle is 19.2m and reaches up to the roof of the cave, and its diameter is 10cm. The whole body of the Needle is transparent. In 1998, it was insured for RMB 10million."
            ]
        },
        "yjjjq":{
            title: "Yuanjiajie Scenic Area",
            pics: ["../../../img/images/viewpoints/5-2_573_353.png","../../../img/images/viewpoints/5-3_217_346.png","../../../img/images/viewpoints/5-4_337_346.png"],
            brief: [
                "Yuanjiajie Scenic Area is located at the Northwest of the Zhangjiajie Forest Park. It was named after a clan with “Yuan” as their family name. It covers a total area of 1200 hectares, and thus is commonly named as “forty-eight Li (one Li equals to half kilometer)” Yuanjiajie. The sceneries in this area are known for its steepness and wonderful views. The air path set over the 3500 m’s steep cliff connects many wonderful sights together, including the Back Garden, breathtaking Mihun Stage, Magic Turtle Asking Heaven, Five Women Go on an Expedition and the First Bridge under the Sun, and thus forms one of the most wonderful and unique picture scroll in Zhangjiajie."
            ]
        },
        "fhgc":{
            title: "Phoenix of ancient city(FengHuang)",
            pics: ["../../../img/images/viewpoints/8-2_573_353.png","../../../img/images/viewpoints/8-3_573_346.png"],
            brief: [
                "The Phoenix Ancient Town is located in Xiangxi Tujia & Miao Autonomous Prefecture,Hunan Province,and also border on the southwestern Guizhou Province and the West Songtao, Tongren County.It is one of the smaller counties in Hunan,but now it is known as the most beautiful ancient town for its long history and well-preserved appearances.The name of Phoenix town mainly derived from the Phoenix Mountain which is in a phoenix shape.",
                "The Phoenix town today consist of 5 zones and 27 townships. With 300,000 people, which is a multi-ethnic County with Miao, Han, Tujia, and so on. The County is in sub-tropical moist monsoon climate,and the average annual temperature is 15.9 ℃. Phoenix is not only rich in natural resources,beautiful mountains and rivers, but also possessing many scenic and historical sites. Next are 9 famous spots in the ancient town."
            ]
        },
        "wall":{
            title: "South-Great Wall",
            pics: ["../../../img/images/viewpoints/S_wall2.jpg","../../../img/images/viewpoints/S_wall3.jpg","../../../img/images/viewpoints/S_wall4.jpg"],
            brief: [
                "Southern Great Wall, which is about 10 kilometers away from the Fenghuang (Phoenix) Ancient city. In April, Year 2000, the archaeologists in China discovered that more than 190 kilometers of the ancient Great wall were the same as those of the northern Great Wall. Experts confirm that it was part of the Ming Dynasty Great Wall built to defend the kingdom against the Miao people of the south.",
                "In Phoenix County, this section of the Southern Great Wall has also similar defensive function and structures as the Ming-dynasty Great Wall. Located at the border of Hunan and Guizhou, the Southern Great Wall starts at Xiqueying Village of Guzhang County and ends at the Tingziguan Pass. By the specialist of China, the Southern Great Wall was first built in 1615 at a large financial cost. Mostly constructed on high and precipitous ridges, about 5,000 soldiers used to be stationed along this section of the Southern Great Wall in China."
            ]
        },
        "canyon":{
            title: "The longest glass bridge in the world",
            pics: ["../../../img/images/viewpoints/canyon2.jpg","../../../img/images/viewpoints/canyon3.jpg"],
            brief: [
                "Acrophobiacs beware… China’s newest bridge isn’t for the faint of heart.",
                "Stretching 380m across a section of Zhangjiajie’s Grand Canyon, the new pedestrian bridge will have a completely glass floor. Visitors who dare venture forth can see the full 300m drop to the canyon’s bottom below.",
                "“I believe in nature, harmony, balance and beauty. Nature is beautiful as is,” said Haim Dotan, the Tel Aviv-based architect who designed the bridge’s concept. “The Zhangjiajie Glass Bridge was designed to be invisible as possible – a white bridge disappearing into the clouds."
            ]
        },
        "wt":{
            title: "The Bund is the symbol of Shanghai",
            pics: ["../../../img/images/viewpoints/wt2.jpg","../../../img/images/viewpoints/wt3.jpg"],
            brief: [
                "Located along the Huangpu River, the Bund shows off Shanghai’s outstanding foreign buildings, most of which were erected before 1937. To the Europeans, the Bund was Shanghai’s answer to Wall Street."
            ]
        },
        "jbx":{
            title: "Golden Whip Brook",
            pics: ["../../../img/images/viewpoints/jbx2.png","../../../img/images/viewpoints/jbx3.png"],
            brief: [
                "It is named after its representative attraction Golden Whip Rock. The canyon stretches seven kilometers from Laomo Bay to Water around Four Gates. Rock columns and peaks stand along the banks; the stream runs smoothly among them, laces together pools and waterfalls. Ancient trees and flowers as well as the rare fowls and strange animals grow and flourish together, forming an extremely beautiful and elegant ecological environment. Many famous Chinese TV series and movies including “Journey to the West” were filmed here. It is known as “the most beautiful canyons in the world”. The main scenic spots in this area include Greeting Rock, Golden Whip Rock, Purple Weed Pond, Thousands of Miles’ Meeting and Water Around Four Gates, etc."
            ]
        },
        "mlxx":{
            title: "Grande mise en scène et beau spectacle",
            pics: ["../../../img/images/viewpoints/mlxx2.png","../../../img/images/viewpoints/mlxx3.jpg"],
            brief: [
                "The stage art design and elaborate ancient melodies and gorgeous lighting effects, gorgeous costumes and a powerful lineup, a meticulous dedication for tourists high taste of Xiangxi ethnic cultural feast; site of 2 large screen computer live, 6 sets of America's top JBL sound, automatic mechanical lifting stage, 4800 square meters of indoor and outdoor venues, giving visitors a hitherto unknown sensory stimulation and visual experience. Walking into 'charming Xiangxi', you enter the deepest part of ancient mysterious culture in Xiangxi!"
            ]
        }
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
    });
    $(".modal-view-point").on("click", function () {
        $("body").css("overflow","auto");
        $(".left-side").empty();
        $(".right-side section").empty();
        $(".right-side header").text("");
        $(".modal-view-point").css("display","none");
    });
    $(".hotel-image img").on("click",function (e) {
        e.stopPropagation();
        $("body").css("overflow","hidden");
        var imgSrc = $(e.target).attr("src");
        $("#modal-hotel-view").find("img").attr("src", imgSrc);
        $("#modal-hotel-view").css("display","block");
    });
    $("#modal-hotel-view").on("click", function () {
        $("body").css("overflow","auto");
        $("#modal-hotel-view").css("display","none");
    });
})();