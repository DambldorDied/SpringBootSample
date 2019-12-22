$(function () {
    // alert("loaded");

    $.ajax({
        url: '/api/products/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (product) {
            for (let i = 0; i < product.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + product[i].id + "</td>" +
                    "<td>" + product[i].name + "</td>" +
                    "<td>" + product[i].price + "</td>" +
                    "<td>" + product[i].amount + "</td>" +
                    "<td>" +
                    "<button class=\"btn btn-outline-warning\" data-toggle=\"modal\" data-target=\"#edit-modal\" onclick=\"fillModal("+product[i].id+")\">Редактировать</button>" +
                    "<a class=\"btn btn-danger\" href=\"/products/buy?id=\" + product[i].id>Delete</a>" +
                    "</td>" +
                    "</tr>")
            }
        },
        error: function (response) {
            alert('error');
            console.log(response);
        }
    });


})

function fillModal(id) {
    $.ajax({
        method: "get",
        url: "/api/products/get?id=" + id,
        contentType: "application/json; charset=utf-8",
        success: function (product) {
            $("#id-edit").val(product.id);
            $("#name-edit").val(product.name);
            $("#price-edit").val(product.price);
            $("#amount-edit").val(product.amount);
        }

    })
}

function editProduct() {
    //сгенерировать модальное окно
    var id = $("#id").val();
    var name = $("#name-new").val();
    var price = $("#price-new").val();
    var amount = $("#amount-new").val();

    var newProduct = {
        'name': name,
        'price': price,
        'amount': amount
    }
    $.ajax({
        //запихиваем инфу в нужные поля
        url: '/api/products/add',
        method: 'post',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(newProduct),
        success: function () {
            window.location.replace("/products/all")
        },
        error: function (error) {

        }

    });



}
function addProduct() {
    //сгенерировать модальное окно
    var name = $("#name").val();
    var price = $("#price").val();
    var amount = $("#amount").val();

    var newProduct = {
        'name': name,
        'price': price,
        'amount': amount
    }
    $.ajax({
        //запихиваем инфу в нужные поля
        url: '/api/products/add',
        method: 'post',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(newProduct),
        success: function () {
            window.location.replace("/products/all")
        },
        error: function (error) {

        }

    });

}