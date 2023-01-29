
// js 첫 문장에 var main = {} 을 선언 
// main 이라는 변수의 속성으로 function 을 추가 
// 아래처럼 main 이라는 변수에 함수를 선언 시 다른 JavaScript 파일을 덮어씌우는 것을 방지할 수 있음
// 동일한 함수명을 가진 외부 자바스크립트 파일이 있을 시 나중에 Load 된 JavaScript 파일 이 같은 함수명을 덮어 씌움

var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
		
        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert("ERR 입니다 : " + JSON.stringify(error));
        });
    }
};

main.init();