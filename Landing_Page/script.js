$(document).ready(function () {
    $("#arrow").mouseenter(function () {
        $("#arrow_circle").addClass('toggleArrow');
    });
});

$(document).ready(function () {
    $("#arrow").mouseleave(function () {
        $("#arrow_circle").removeClass('toggleArrow');
    });
});


$("#arrow").on("click", function () {
    $("html,body").animate({
        scrollTop: $("main").offset().top
    }, 1000);
    $("#arrow,hgroup").animate({
        opacity: 0
    }, 1000);
})

$(document).ready(function () {
    $("html,body").animate({
        scrollTop: 0
    }, 10); //100ms for example
});

$(document).scroll(function () {

    var scrollPos = $(document).scrollTop();
    var sectionOffset = $("main").offset().top;

    //  console.log(scrollPos);
    //    console.log(sectionOffset + "polozenie sekcji");

    if (scrollPos < sectionOffset) {
        $("#arrow,hgroup").css('opacity', 1 - 1.4 * scrollPos / sectionOffset);
    }

})