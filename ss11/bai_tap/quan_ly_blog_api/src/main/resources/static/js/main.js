const display = (page) => {
    $.ajax({
        url: 'http://localhost:8080/api/v1/blogs?page=' + page,
        type: 'GET',
        dataType: 'json',
        success: function (blogs) {
            let content = blogs.content.map((blog, i) => (
                `
               <tr>
                    <td>${i + 1}</td>
                    <td>${blog.title}</td>
                    <td>${blog.categoryName}</td>
                    <td><button class="btn btn-danger" onclick="deleteBlog(${blog.id})">Delete</button>
                    <button class="btn btn-info" onclick="showUpdate(${blog.id})">Update</button></td>
                </tr>
            `)
            );
            $("#content").html(content);

            let pages = "";
            for (let i = 0; i < blogs.totalPages; i++) {
                pages += `
                    <li class="page-item">
                        <a class="page-link" onclick="display(${i})">${i + 1}</a>
                    </li>
                `;
            }
            $("#pagination").html(pages);
        }
    });
}

const getAllCategories = () => {
    $.ajax({
        url: 'http://localhost:8080/api/v1/categories',
        method: 'get',
        dataType: 'json',
        success: (categories) => {
            let categoryOptions = categories.map((category) => (
                `
                <option value="${category.id}">${category.name}</option>
                `
            ));
            $('#category').html(categoryOptions);
            $('#categoryId').html(categoryOptions);
        }
    })
}
getAllCategories();
display(0);

const deleteBlog = (id) => {
    $.ajax({
        url: 'http://localhost:8080/api/v1/blogs/' + id,
        method: 'delete',
        success: () => {
            alert(`Blog deleted successfully`);
            display();
        }
    })
}

const showUpdate = (id) => {
    $.ajax({
        url: 'http://localhost:8080/api/v1/blogs/update/' + id,
        dataType: 'json',
        method: 'get',
        success: (blog) => {
            showCreateForm();
            $('#title').val(blog.title);
            $('#contentBlog').val(blog.content);
            $('#category').val(blog.categoryId);
            $('#create-button').hide();
        }
    })
}

const showCreateForm = () => {
    $('#create-form').toggle();
}

const createBlog = () => {
    let title = $('#title').val();
    let content = $('#contentBlog').val();
    let categoryId = $('#category').val();

    let blog = {
        title: title,
        content: content,
        category: {
            id: categoryId
        }
    };
    $.ajax({
        url: 'http://localhost:8080/api/v1/blogs',
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(blog),
        success: () => {
            alert('Blog created successfully');
            display(0);
            $('#create-form').hide();
            $('#title').val('');
            $('#contentBlog').val('');
            $('#category').val('');
        }
    })
}

const search = () => {
    let keyword = $('#keyword').val();
    let categoryId = $('#categoryId').val();
    $.ajax({
        url: `http://localhost:8080/api/v1/blogs/search?keyword=${keyword}&categoryId=${categoryId}`,
        method: 'get',
        dataType: 'json',
        success: (blogs) => {
            let content = blogs.content.map((blog, i) => (
                `
               <tr>
                    <td>${i + 1}</td>
                    <td>${blog.title}</td>
                    <td>${blog.categoryName}</td>
                    <td><button class="btn btn-danger" onclick="deleteBlog(${blog.id})">Delete</button>
                    <button class="btn btn-info" onclick="showUpdate(${blog.id})">Update</button></td>
                </tr>
            `)
            );
            $("#content").html(content);

            let pages = "";
            for (let i = 0; i < blogs.totalPages; i++) {
                pages += `
                    <li class="page-item">
                        <a class="page-link" onclick="display(${i})">${i + 1}</a>
                    </li>
                `;
            }
            $("#pagination").html(pages);
        }
    })

}