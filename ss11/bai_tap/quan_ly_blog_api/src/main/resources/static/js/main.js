let isSearching = false;
const display = (page) => {
    isSearching = false;
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
            renderPagination(blogs);
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
            $('#blogId').val(blog.id);
            $('#title').val(blog.title);
            $('#contentBlog').val(blog.content);
            $('#category').val(blog.categoryId);
            $('#create-button').hide();
            $('#create-save-btn').hide();
            $('#update-save-btn').show();
        }
    })
}

const showCreateForm = () => {
    $('#blogId').val('');
    $('#title').val('');
    $('#contentBlog').val('');
    $('#category').val('');
    $('#create-form').toggle();
    $('#create-button').hide();
    $('#create-save-btn').show();
    $('#update-save-btn').hide();
}
const updateBlog = () => {
    let id = $('#blogId').val();
    let title = $('#title').val();
    let content = $('#contentBlog').val();
    let categoryId = $('#category').val();

    let blog = {
        id: id,
        title: title,
        content: content,
        category: {
            id: categoryId
        }
    };
    $.ajax({
        url: `http://localhost:8080/api/v1/blogs/update/${id}`,
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(blog),
        success: () => {
            alert('Blog update successfully');
            display(0);
            $('#create-form').hide();
            $('#title').val('');
            $('#contentBlog').val('');
            $('#category').val('');
        }
    })
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

const search = (page) => {
    isSearching = true;
    let keyword = $('#keyword').val();
    let categoryId = $('#categoryId').val();
    $.ajax({
        url: `http://localhost:8080/api/v1/blogs/search?page=${page}&keyword=${keyword}&categoryId=${categoryId}`,
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

            renderPagination(blogs);

        }
    })

}

const renderPagination = (blogs) => {
    let pages = '';
    for (let i = 0; i < blogs.totalPages; i++) {
        pages += `
            <li class="page-item ${i === blogs.number ? 'active' : ''}">
                <a class="page-link" data-page="${i}">${i + 1}</a>
            </li>
        `;
    }
    $('#pagination').html(pages);
};
$(document).ready(function () {
    $('#pagination').on('click', '.page-link', function () {
        const page = $(this).data('page');

        if (isSearching) {
            search(page);
        } else {
            display(page);
        }
    });

    display(0);
});