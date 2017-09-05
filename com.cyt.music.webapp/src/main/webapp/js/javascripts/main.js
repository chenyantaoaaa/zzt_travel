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
        "hkzj":{
          title: "Concessions étrangère de Hankou",
          pics: ["../../img/images/viewpoints/1-2_573_353.png","../../img/images/viewpoints/1-3_277_346.png","../../img/images/viewpoints/1-4_277_346.png"],
          brief: [
              "Concessions étrangère de Hankou où fait une fusion des bâtiments Europe et la culture oriente. Hankou, où étaient autrefois situés les concessions étrangères de l’Angleterre, la Russie, la France, l’Allemand, le Japon et le Belgique, aujourd'hui centre des affaires internationales, il est connu comme « Est Chicago ».Et une concession française d’Hankou d'environ 33 hectares en 1896",
          ]
        },
        "ljyy":{
            title: "Visite fleuve de Yangz et la rivière Han par bateau le soir",
            pics: ["../../img/images/viewpoints/2-2_573_353.png","../../img/images/viewpoints/2-3_573_346.png"],
            brief: [
                "Après s’adaptent au pont sur la seine, le pont sur la fleuve Bleu est extrêmement spectaculaire, " +
                "dont ils vous profondément touché dans votre cœur.Wuhan, jadis capitale de l’antique royaume de Wu s’est imposée dans l’histoire lors de la rébellion militaire qui éclata en son sein, et qui devait précipiter la chute de la dynastie des Qing, en 1911. Aujourd’hui la ville est un des fleurons de la révolution économique chinoise, sa situation géographique entre Pékin et Canton, sur le cours moyen du fleuve Yangzi, a assuré son développement industriel et portuaire. Grâce à la présence du Yangzi et de nombreux lacs, une cité agréable. Des petites rues animées, bordées de gargotes attrayantes, compensent les secteurs piétonniers sans caractères et le verdoyant quartier des anciennes concessions constitue une base idéale pour découvrir la vie nocturne plutôt effervescente."
            ]
        },
        "tmhx":{
            title: "Le renard du Mont Tianmen ",
            pics: ["../../img/images/viewpoints/3-2_573_353.png","../../img/images/viewpoints/3-3_287_346.png","../../img/images/viewpoints/3-4_277_346.png"],
            brief: [
                "Le spectacle Le renard du Mont Tianmen a été créé en septembre 2009 par deux opérateurs privés de Zhangjiajie et de Guilin qui y ont investi cent millions de Yuan (17 millions d’euros). Ce spectacle de plein air est un phénomène « culturel », au sens de l'engouement qu'il connaît auprès des touristes domestiques chinois, très répandu dans les sites paysagers en Chine. Il répond sans doute plus à une demande de l' « ethnie » Han majoritaire plutôt qu’à une réelle volonté d'une mise en spectacle vivant qui partirait d'une initiative locale. Basé sur le son et lumière, il réduit l’histoire à des clichés et des effets. Aussi est-il paradoxal, puisqu'il satisfait « facilement » le désir d'exotisme d'une clientèle chinoise par l'excellence de l'artefact et le recours à une symbolique stéréotypée alors qu'il néglige les éléments culturels plus difficiles d'accès à un tourisme issu d'une classe moyenne en pleine émergence. "
            ]
        },
        "tjfqy":{
            title: "Le Parc culturel de l'ethnie Tujia",
            pics: ["../../img/images/viewpoints/4-2_573_353.png","../../img/images/viewpoints/4-3_573_346.png"],
            brief: [
                "Le Parc culturel de l'ethnie Tujia est situé à Zhangjiajie. Il a été érigé sur le site des vestiges des anciennes résidences Tujia et a ouvert ses portes au public en 1997. Le parc est considéré comme un lieu sacré et était consacré au culte des dieux, aux prières et à la célébration des fêtes.Ici, vous trouverez la maison des « Neuf cieux », la plus grande maison en bois de Chine. Située près de la montagne, cette maison, mesurant 48m de haut et comprenant 72 étages, a été construite selon le style architectural de l'ethnie Tujia.Vous pourrez non seulement visiter de magnifiques bâtiments, mais aussi s'initier aux us et coutumes de l’ethnie Tujia : cérémonie de mariage traditionnel, costumes traditionnels, techniques d' « impression et de teinture » ou bien encore les sculptures de pierres et de racines. Les habitants locaux effectuent de temps en temps des représentations de danses folkloriques pour le plus grand bonheur des touristes."
            ]
        },
        "tzfjq":{
            title: "Tianzishan",
            pics: ["../../img/images/viewpoints/tzs2.jpg","../../img/images/viewpoints/6-3_277_346.png","../../img/images/viewpoints/6-4_277_346.png"],
            brief: [
                "La réserve naturelle de Tianzi Shan est l’endroit idéal où se plonger en pleine nature. Il suffit d’emprunter le téléphérique du site pour atteindre les sommets escarpés de Tianzishan. Là, l’Homme se rend compte à quel point il n’est rien comparé à la nature.",
                "Tianzi Shan est principal constitué de cascades, de ponts, de forêts de pierre et de grottes. Cependant, 4 spectacles naturels sont considérés comme incontournables pour tout voyageur visitant Tianzishan : nuages de brouillard entourant les sommets de la montagne, vue étonnantes du soleil levant, nuit de pleine lune et pics enneigés. Vous l’aurez donc compris, ce n’est pas en visitant le site une demi-journée que vous pourrez admirer les plus jolis paysages de Tianzishan. Heureusement, 80 plateformes d’observations ont été installées pour donner plus d’opportunité d’apercevoir ces paysages mystiques."
            ]
        },
        "hld":{
            title: "Grotte de Huanglong",
            pics: ["../../img/images/viewpoints/7-2_573_353.png","../../img/images/viewpoints/7-3_277_346.png","../../img/images/viewpoints/7-4_277_346.png"],
            brief: [
                "Aujourd'hui, découvrez le Parc de Wulingyuan. Démarrez la découverte du site en beauté avec la montagne de Tianmenshan qui forme un immense trou de serrure découpé dans le flanc de la montagne. La montée en télécabine sera la bienvenue, d'autant plus que cette télécabine vous fera parcourir 7455 mètres de distance ! Vous aurez ainsi tout le temps nécessaire pour admirer les impressionnants pics karstiques de Wulingyuan. La sensation de flotter au-dessus des nuages sera unique !",
                "L'après-midi, vous partez pour une partie différente de Wulingyuan,  la réserve naturelle de Suoxi. Sur place, vous visitez la Grotte du Dragon Jaune (Grotte de Huanglong), l'une des plus vastes du monde à l'est de l'entrée de Wulingyuan.. Avant d'arriver au palais du dragon, il vous faudra prendre une petite embarcation voguant sur une rivière souterraine."
            ]
        },
        "yjjjq":{
            title: "Yuangjiajie",
            pics: ["../../img/images/viewpoints/5-2_573_353.png","../../img/images/viewpoints/5-3_217_346.png","../../img/images/viewpoints/5-4_337_346.png"],
            brief: [
                "Les monts Hallelujah d'Avatar",
                "Vous emprunterez une voiture écologique pour atteindre le pied de la Montagne de Tianzi Shan (Réserve naturelle du Tianzi Shan), connue pour ses quatre spectacles naturels aux noms bien poétiques : nuages de brouillard entourant les sommets de la montagne, vues étonnantes du soleil levant, nuit de pleine lune et pics enneigés. Le télésiège vous emportera au sommet, d'où vous découvrirez cette contrée merveilleuse où pics karstiques, forêts et cascades s'entremêlent majestueusement.",
                "Vous passerez notamment par le fameux site de Yuanjiajie, par un impressionnant pont suspendu (Tiansheng Qiao). Le sentier passe par une montagne récemment rebaptisée « mont Hallelujah d'Avatar », reliée au film à succès Avatar, ce parc céleste donna des idées au réalisateur américain les décors oniriques de la planète Pandora. Du rêve à la réalité, grand angle sur le Parc national de Zhangjiajie."
            ]
        },
        "fhgc":{
            title: "La vieille ville Fenghuang",
            pics: ["../../img/images/viewpoints/8-2_573_353.png","../../img/images/viewpoints/8-3_573_346.png"],
            brief: [
                "Fenghuang, petite Venise de la Chine ancestrale. La ville, dont le nom signifie «cité du phoenix», est avant tout le berceau de l'ethnie Miao. Prenez la journée pour apprécier tous les charmes de l'ancien bourg de Fenghuang.",
                "Son architecture, remarquable imbroglio de maisons sur pilotis, de ponts et de passerelles, agrippés aux rives escarpées de la rivière Tuo Jiang, remonte aux dynasties Ming et Qing. Le soir, des guirlandes lumineuses redessinent les façades et les rues résonnent des karaokés bondés et bruyants. Architecture en bois, pierre grise, cours d'eau filant paisiblement, le tout surmonté de montagnes et de brumes sont le lot de ce village classé à l'Unesco."
            ]
        },
        "wall":{
            title: "Construite dans les arêtes abruptes",
            pics: ["../../img/images/viewpoints/S_wall2.jpg","../../img/images/viewpoints/S_wall3.jpg","../../img/images/viewpoints/S_wall4.jpg"],
            brief: [
                "Quand on parle de la grande muraille de Chine, on pense tout de suite à la grande muraille des Ming de la passe de Shanhaiguan à la passe de Jiayuguan. Mais à Fenghuang Hunnan, au sud de la Chine, il y a aussi une grande muraille pour emprisonner les minorités Miao. Elle a été construite pendant la dynastie Ming, sous le règne de Ming Shenzong (1572 - 1620).",
                "La Grande Muraille du sud possède de plus de 1300 miradors, forteresses d’inondation, et endroits pour monter la garde etc. Seulement dans le district de Feng Huang, il y a plus de 800 miradors, forteresses d’inondation, et endroits pour monter la garde. À ce moment-là, il y avait 4000-5000 soldats. Le rempart a 3 mètres de haut, 2 mètres de large au fond. Les lieux locaux sont baptisés par ces miradors etc."
            ]
        },
        "canyon":{
            title: "Le pont en verre le plus long du monde",
            pics: ["../../img/images/viewpoints/canyon2.jpg","../../img/images/viewpoints/canyon3.jpg"],
            brief: [
                "Le 29 septembre 2015, le très célèbre pont de verre de Zhangjiajie a été inauguré. Surplombant le Grand Canyon de Zhangjiajie, ce pont s’élève à 300m au-dessus du vide et s’étend sur 430m de long (pour 6m de large).",
                "Là où les choses deviennent intéressantes, c’est que ce pont est en grande partie en verre. Vertige et sensations fortes sont donc garantis ! Il est d’ailleurs très facile de trouver en ligne des vidéos de visiteurs figés sur place qui ne peuvent plus avancer. Alors avant de rigoler d’eux, prenez votre courage à deux mains et venez traverser le plus long pont en verre du monde ! Le pont de verre de Zhangjiajie offre une vue d’oiseau à couper le souffle sur le Grand Canyon de Zhangjiajie."
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