const display = () => {
    $.ajax({
        url: 'http://localhost:8080/api/v1/products',
        method: 'get',
        dataType: 'json',
        success: (data) => {
            let content = data.content.map((product, i) => (
                `<tr>
                            <td>${i + 1}</td>
                            <td>${product.model}</td>
                            <td>${product.producer}</td>
                            <td>${product.price}</td>
                            <td><button class="deleteSmartphone" onclick="deleteProduct(${product.id})" >Delete</button>
                            <button class="deleteSmartphone"  onclick="showUpdateForm(${product.id})" >Update</button></td>
                        </tr>`
            ));
            $("#content").html(content);
        },
        error: (response) => {
            const message = response.message;
        }
    });
}
display();

const deleteProduct = (id) => {
    $.ajax({
        url: "http://localhost:8080/api/v1/products?id=" + id,
        method: 'delete',
        success: function () {
            alert("Product deleted successfully");
            display();
        }
    })
};


const addProduct = () => {
    let model = $("#model").val();
    let producer = $("#producer").val();
    let price = $("#price").val();
    let product = {
        model: model,
        producer: producer,
        price: price
    }
    $.ajax({
        url: 'http://localhost:8080/api/v1/products',
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(product),
        //tên API
        //xử lý khi thành công
        success: () => {
            alert("Product add successfully");
            display();
        }
    });

}

const showUpdateForm = (id) => {
    $.ajax({
        url: "http://localhost:8080/api/v1/products?id=" + id,
        method: 'put',
        dataType: 'json',
        success: (product) => {
            $("#id").val(product.id);
            $("#model").val(product.model);
            $("#producer").val(product.producer);
            $("#price").val(product.price);
            $("#add-btn").hide();
            $("#update-btn").show();
        }
    })
}

const updateProduct = () => {
    let id = $("#id").val();
    let model = $("#model").val();
    let producer = $("#producer").val();
    let price = $("#price").val();
    let product = {
        model: model,
        producer: producer,
        price: price
    }
    $.ajax({
        url: 'http://localhost:8080/api/v1/products?id=' + id,
        method: 'patch',
        contentType: 'application/json',
        data: JSON.stringify(product),
        //tên API
        //xử lý khi thành công
        success: () => {
            alert("Product update successfully");
            display();
        }
    });

}