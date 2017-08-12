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
              "Concessions étrangère de Hankou où fait une fusion des bâtiments Europe et la culture oriente. Hankou, où étaient autrefois situés les concessions étrangères de l’Angleterre, la Russie, la France, l’Allemand, le Japon et le Belgique, aujourd'hui centre des affaires internationales, il est connu comme « Est Chicago ».Et une concession française d’Hankou d'environ 33 hectares en 1896",
          ]
        },
        "ljyy":{
            title: "两江夜游",
            pics: ["../../img/images/viewpoints/2-2_573_353.png","../../img/images/viewpoints/2-3_573_346.png"],
            brief: [
                "Après s’adaptent au pont sur la seine, le pont sur la fleuve Bleu est extrêmement spectaculaire, " +
                "dont ils vous profondément touché dans votre cœur.Wuhan, jadis capitale de l’antique royaume de Wu s’est imposée dans l’histoire lors de la rébellion militaire qui éclata en son sein, et qui devait précipiter la chute de la dynastie des Qing, en 1911. Aujourd’hui la ville est un des fleurons de la révolution économique chinoise, sa situation géographique entre Pékin et Canton, sur le cours moyen du fleuve Yangzi, a assuré son développement industriel et portuaire. Grâce à la présence du Yangzi et de nombreux lacs, une cité agréable. Des petites rues animées, bordées de gargotes attrayantes, compensent les secteurs piétonniers sans caractères et le verdoyant quartier des anciennes concessions constitue une base idéale pour découvrir la vie nocturne plutôt effervescente."
            ]
        },
        "tmhx":{
            title: "天门狐仙",
            pics: ["../../img/images/viewpoints/3-2_573_353.png","../../img/images/viewpoints/3-3_287_346.png","../../img/images/viewpoints/3-4_277_346.png"],
            brief: [
                "Le spectacle Le renard du Mont Tianmen a été créé en septembre 2009 par deux opérateurs privés de Zhangjiajie et de Guilin qui y ont investi cent millions de Yuan (17 millions d’euros). L'aménagement réalisé consiste en un vaste plateau de 10 000 mètres carrés en verre trempé. Il sert de scène aux 530 acteurs, dont 216 professionnels et 264 étudiants artistes de l’école de Zhangjiajie. Cinquante personnes en assurent la régie, et le théâtre de plein air peut accueillir jusqu’à 3 080 spectateurs.Avec l’aide de la technique du son et lumière, de la danse et de la musique, le spectacle de plein air lie les approches narratives et romanesques. Les poètes et peintres paysagistes ont immortalisé ses montagnes en forme de pains de sucre, et fixé son paysage dans l’inconscient collectif du pays. Les décors, les chants, l'arrière -plan de Mont Tianmen, ces effets sont impressionnants. Il y a sous-titres anglais. C'est définitivement un incontournable à Zhangjiajie. À partir d’une étude de cas (Zhangjiajie), cet article traite du statut qui est donné au spectacle de plein air dans les sites paysagers remarquables montagnards chinois. Ce type de manifestation y est très répandu depuis 2004. Sous la forme d'un son et lumière, il procède d'une approche mythifiée et très formalisée du paysage dans le registre du merveilleux, qui essaie de lier le spectaculaire des effets techniques à une approche artistique stéréotypée. En tant qu’objet de consommation touristique, il conduit à revisiter la notion de « culture » qui lui est accolée, en soulignant le décalage qu'elle présente par rapport aux normes occidentales.Le spectacle de plein air est un phénomène « culturel », au sens de l'engouement qu'il connaît auprès des touristes domestiques chinois, très répandu dans les sites paysagers en Chine. Il répond sans doute plus à une demande de l' « ethnie » Han majoritaire plutôt qu’à une réelle volonté d'une mise en spectacle vivant qui partirait d'une initiative locale. Basé sur le son et lumière, il réduit l’histoire à des clichés et des effets. Aussi est-il paradoxal, puisqu'il satisfait « facilement » le désir d'exotisme d'une clientèle chinoise par l'excellence de l'artefact et le recours à une symbolique stéréotypée alors qu'il néglige les éléments culturels plus difficiles d'accès à un tourisme issu d'une classe moyenne en pleine émergence."
            ]
        },
        "tjfqy":{
            title: "土家风情园",
            pics: ["../../img/images/viewpoints/4-2_573_353.png","../../img/images/viewpoints/4-3_573_346.png"],
            brief: [
                "Le Parc culturel de l'ethnie Tujia est situé à Zhangjiajie. Il a été érigé sur le site des vestiges des anciennes résidences Tujia et a ouvert ses portes au public en 1997. Le parc est considéré comme un lieu sacré et était consacré au culte des dieux, aux prières et à la célébration des fêtes.Ici, vous trouverez la maison des « Neuf cieux », la plus grande maison en bois de Chine. Située près de la montagne, cette maison, mesurant 48m de haut et comprenant 72 étages, a été construite selon le style architectural de l'ethnie Tujia.Vous pourrez non seulement visiter de magnifiques bâtiments, mais aussi s'initier aux us et coutumes de l’ethnie Tujia : cérémonie de mariage traditionnel, costumes traditionnels, techniques d' « impression et de teinture » ou bien encore les sculptures de pierres et de racines. Les habitants locaux effectuent de temps en temps des représentations de danses folkloriques pour le plus grand bonheur des touristes."
            ]
        },
        "tzfjq":{
            title: "天子风景区",
            pics: ["../../img/images/viewpoints/6-2_573_353.png","../../img/images/viewpoints/6-3_277_346.png","../../img/images/viewpoints/6-4_277_346.png"],
            brief: [
                "Paysages mystiques de Tianzishan La réserve naturelle de Tianzi Shan est l’endroit idéal où se plonger en pleine nature. Il suffit d’emprunter le téléphérique du site pour atteindre les sommets escarpés de Tianzishan. Là, l’Homme se rend compte à quel point il n’est rien comparé à la nature.Tianzi Shan est principal constitué de cascades, de ponts, de forêts de pierre et de grottes. Cependant, 4 spectacles naturels sont considérés comme incontournables pour tout voyageur visitant Tianzishan : nuages de brouillard entourant les sommets de la montagne, vue étonnantes du soleil levant, nuit de pleine lune et pics enneigés. Vous l’aurez donc compris, ce n’est pas en visitant le site une demi-journée que vous pourrez admirer les plus jolis paysages de Tianzishan. Heureusement, 80 plateformes d’observations ont été installées pour donner plus d’opportunité d’apercevoir ces paysages mystiques.Sommets de Tianzi ShanLes plus beaux panoramas s’admirent bien sûr depuis les hauteurs de la réserve naturelle. Les voyageurs prennent généralement le téléphérique afin d’atteindre les hauteurs. En moins de 7min, ils parcourent alors un peu plus de 2km de distance et montent 700m de dénivelé pour surplomber la vallée. La traversée est des plus agréables mais ce sont surtout les pics auxquels il est possible d’accéder ensuite qui valent le détour : pics Yubi, Xiangnüsanhua, Shenbinghui,… Tous ces sites ont un nom très poétique en chinois et sont souvent très subjectifs pour chaque voyageur.Aujourd'hui, profitez d'une journée tout en douceur. Vous emprunterez une voiture écologique pour atteindre le pied de la Montagne de Tianzi Shan (Réserve naturelle du Tianzi Shan), connue pour ses quatre spectacles naturels aux noms bien poétiques : nuages de brouillard entourant les sommets de la montagne, vues étonnantes du soleil levant, nuit de pleine lune et pics enneigés. Le télésiège vous emportera au sommet, d'où vous découvrirez cette contrée merveilleuse où pics karstiques, forêts et cascades s'entremêlent majestueusement.Vous passerez notamment par le fameux site de Yuanjiajie, par un impressionnant pont suspendu (Tiansheng Qiao). Le sentier passe par une montagne récemment rebaptisée « mont Hallelujah d'Avatar », reliée au film à succès Avatar. Vous montez un haut plateau par l'ascenseur panoramique de Bailong qui couvere en moins de 2 minutes les 335m de la falaise jusquà Yuanjiajie. Pour des vues plus reposants, prenez le tramway touristique qui parcourt les paysages de la galerie Dix Milles au fil du canyon."
            ]
        },
        "hld":{
            title: "黄龙洞",
            pics: ["../../img/images/viewpoints/7-2_573_353.png","../../img/images/viewpoints/7-3_277_346.png","../../img/images/viewpoints/7-4_277_346.png"],
            brief: [
                "Aujourd'hui, découvrez le Parc de Wulingyuan. Démarrez la découverte du site en beauté avec la montagne de Tianmenshan qui forme un immense trou de serrure découpé dans le flanc de la montagne. La montée en télécabine sera la bienvenue, d'autant plus que cette télécabine vous fera parcourir 7455 mètres de distance ! Vous aurez ainsi tout le temps nécessaire pour admirer les impressionnants pics karstiques de Wulingyuan. La sensation de flotter au-dessus des nuages sera unique !",
                "L'après-midi, vous partez pour une partie différente de Wulingyuan,  la réserve naturelle de Suoxi. Sur place, vous visitez la Grotte du Dragon Jaune (Grotte de Huanglong), l'une des plus vastes du monde à l'est de l'entrée de Wulingyuan.. Avant d'arriver au palais du dragon, il vous faudra prendre une petite embarcation voguant sur une rivière souterraine."
            ]
        },
        "yjjjq":{
            title: "袁家界风景区",
            pics: ["../../img/images/viewpoints/5-2_573_353.png","../../img/images/viewpoints/5-3_217_346.png","../../img/images/viewpoints/5-4_337_346.png"],
            brief: [
                "Les monts Hallelujah d'Avatar",
                "Profitez d'une journée tout en douceur. Vous emprunterez une voiture écologique pour atteindre le pied de la Montagne de Tianzi Shan (Réserve naturelle du Tianzi Shan), connue pour ses quatre spectacles naturels aux noms bien poétiques : nuages de brouillard entourant les sommets de la montagne, vues étonnantes du soleil levant, nuit de pleine lune et pics enneigés. Le télésiège vous emportera au sommet, d'où vous découvrirez cette contrée merveilleuse où pics karstiques, forêts et cascades s'entremêlent majestueusement.",
                "Vous passerez notamment par le fameux site de Yuanjiajie, par un impressionnant pont suspendu (Tiansheng Qiao). Le sentier passe par une montagne récemment rebaptisée « mont Hallelujah d'Avatar », reliée au film à succès Avatar. Vous montez un haut plateau par l'ascenseur panoramique de Bailong qui couvere en moins de 2 minutes les 335m de la falaise jusquà Yuanjiajie. Pour des vues plus reposants, prenez le tramway touristique qui parcourt les paysages de la galerie Dix Milles au fil du canyon."
            ]
        },
        "fhgc":{
            title: "凤凰古城",
            pics: ["../../img/images/viewpoints/8-2_573_353.png","../../img/images/viewpoints/8-3_573_346.png"],
            brief: [
                "Prenez la journée pour apprécier tous les charmes de l'ancien bourg de Fenghuang. Avec ou sans guide déambulez dans ces rues traditionnelles où se côtoient les anciennes habitations des dynasties Ming et Qing avec les maisons sur pilotis des ethnies Tujia et Miao. Architecture en bois, pierre grise, cours d'eau filant paisiblement, le tout surmonté de montagnes et de brumes sont le lot de ce village classé à l'Unesco. "
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