const inputItems = document.querySelectorAll("table input");
const submitButton = document.querySelector(".submit-button");
const signupBtn = document.querySelector(".signup");

console.log(inputItems);
console.log(submitButton);
console.log(signupBtn);

signupBtn.onclick = () => {
	location.href = "/signup";
}

submitButton.onclick = () => {
	for(let i = 0; i < inputItems.length; i++){
		if(isEmpty(inputItems[i].value)){
			alert( 
				(i == 0 ? "아이디를" : "비밀번호를") + " 입력해주세요."
			);
			return;
		}
	}
	submit();
}

function submit() {
	$.ajax({
		type: "post",
		url: "/signin",
		data: {
			username: inputItems[0].value,
			password: inputItems[1].value
		},
		dataType: "text",
		success: (response) => {
			if(response == "true"){
				alert("로그인 완료")
				location.replace("/index")
			}else {
				alert("아이디, 비밀번호를 확인해주세요")
			}
		},
		error: errorMsg
		
	});
}

//에러
function errorMsg(request, status, error) {
	alert("요청 실패")
	console.log(request.status); //status는 request내의 것을 쓰며, 위에 status매개변수를 쓰는 이유는 자리를 채우기 위해서이다.
	console.log(request.reponseText);
	console.log(error);
}

//input이 비어있을 때 함수
function isEmpty(str) {
	str == "" || str == null || typeof str == undefined;
}