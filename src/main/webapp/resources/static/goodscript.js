$(document).ready(
    function () {
        $('.category_select').on('change',
            function () {
                option = $(this).val(); // get selected value
                var url = "goods?cat_id=" + option;
                window.location = url;
            });
    })

$(document).ready(
    function () {
        $('.manufacturer_select').on('change',function () {
                var cat = $('.category_select').val()
                option = $(this).val(); // get selected value
                var url = "goods?cat_id=" + cat + "&manufactur_id=" + option;
                window.location = url;
            });
    })

$(document).ready(
    function () {
        $('.button-add').on('click',function () {
                option = $(this).val(); // get selected value
                var url = "/cart/add";
                var data = {"goodid": option};
                $.ajax({
                    type: "POST",
                    url: url,
                    data: data,
                    success: function( response ) {
                        alert( response );
                        window.location.reload(true);
                    }
                });
            });
    })

$(document).ready(
    function () {
        $('.delete-button').on('click', function () {
            option = $(this).val(); // get selected value
            var url = "/cart/delete";
            var data = {"id": option};
            $.ajax({
                type: "POST",
                url: url,
                data: data,
                success: function (response) {
                    alert(response);
                    window.location.reload(true);
                }
            });

        });

    })

// function manufacturSelector() {
//     $('#manufacturer_select').on('change',
//         function () {
//             var cat = $('#category_select').val()
//             option = $(this).val(); // get selected value
//             var url = "goods?cat_id=" + cat + "&manufactur_id" + option;
//             window.location = url;
//         })
// }



// $(function() {
//     $("#category_select")
//         .change(
//             function(e) {
//                 var option = $(this).val();
//                 var newUrl = "someUrl?id="+option;
//                 window.location=newUrl;
//             });
// });
