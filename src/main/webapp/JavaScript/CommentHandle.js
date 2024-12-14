document.querySelector('#comment-form').addEventListener('submit', function (e) {
    e.preventDefault();
    const formData = new FormData(this);
    fetch('<%=request.getContextPath()%>/AddComment', {
        method: 'POST',
        body: formData,
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert(data.message);
            } else {
                alert(data.message);
            }
        })
        .catch(error => console.error('Error:', error));
});

function deleteComment(commentId, id_news) {
    if (!confirm("Are you sure you want to delete this comment?")) return;

    const formData = new FormData();
    formData.append('commentId', commentId);
    formData.append('id_news', id_news);

    fetch('<%=request.getContextPath()%>/DeleteComment', {
        method: 'POST',
        body: formData,
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Comment deleted successfully');
                document.querySelector(`#comment-${commentId}`).remove();
            } else {
                alert('Failed to delete comment');
            }
        })
        .catch(error => console.error('Error:', error));
}

document.querySelectorAll('.edit-comment-form').forEach(form => {
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        const formData = new FormData(this);

        fetch('<%=request.getContextPath()%>/UpdateComment', {
            method: 'POST',
            body: formData,
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('Comment updated successfully');
                    const commentContent = this.querySelector('[name="content"]').value;
                    document.querySelector(`#comment-content-${formData.get('commentId')}`).innerText = commentContent;
                } else {
                    alert('Failed to update comment');
                }
            })
            .catch(error => console.error('Error:', error));
    });
});
