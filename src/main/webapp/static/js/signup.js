const inputItems = document.querySelectorAll("table input"); //input태그
const submitBtn = document.querySelector(".submit-button"); //submit버튼
const inputUsername = document.querySelector(".username-input"); //아이디 input태그
const usernameCheckMsg = document.querySelector(".username-check-msg"); //회원가입을 할 수 있는 아이디라고 알려주는 역할

	
console.log(submitBtn);
console.log(inputUsername);
console.log(usernameCheckMsg);



let signupFlag = [false, false, false, false, false];

//빈칸 입력시 빈칸 체크

submitBtn.onclick = () => {
	for(let i = 0; i < inputItems.length; i++){
		if(isEmpty(inputItems[i].value)){
			alert((i == 0 ? "이름을" 
				: i == 1 ? "이메일을"
				: i == 2 ? "아이디를" 
				: "비밀번호를") 
					+" 입력해 주세요." )
							
			signupFlag[i] = false; //비어있는 값에 false를 return
				
			return;
		}
		signupFlag[i] = true; //비어있지 않으니 true
	}
	if(signupFlag[4] == false){ //아이디가 중복이면 alert창을 띄워줌
		alert("아이디가 중복됩니다 다시 입력해주세요.");
		return;
	}
	
	if(!signupFlag.includes(false)){
		submit();
	}
}

//아이디 중복체크기능
inputUsername.onblur = () => {
	let username = inputUsername.value;
	$.ajax({
		type: "get",
		url: `/check/username?username=${username}`,
		dataType: "text",
		success: (response) => {
			console.log(response)
			if(response == "true"){ //true면 데이터베이스안에 이미 아이디가 있다는 뜻
				signupFlag[4] = false;
				usernameCheckMsg.innerHTML = `<td colspan="2">${username}은(는) 중복된 아이디입니다.</td>`
				let usernameCheckMsgColor = document.querySelector(".username-check-msg td");
				usernameCheckMsgColor.style.color = "red";
				
			}else {
				signupFlag[4] = true;
				usernameCheckMsg.innerHTML = `<td colspan="2">${username}은(는) 가입할 수 있는 아이디입니다.</td>`
				usernameCheckMsgColor = document.querySelector(".username-check-msg td");
				usernameCheckMsgColor.style.color = "green";
			}
		},
		error: errorMsg
		
	});
}

//회원가입 요청
function submit() {
	$.ajax({
		type: "post",
		url: "/signup",
		data: {
			name: inputItems[0].value,
			email: inputItems[1].value,
			username: inputItems[2].value,
			password: inputItems[3].value
		},
		dataType: "text",
		success: (response) => {
			if(response == "true"){
				alert("회원가입 완료!");
				location.replace("/signin");
			}else{
				alert("회원가입 실패 \n 다시 시도해주세요.");
				usernameCheckMsg.innerHTML=``;
				document.querySelector("form").reset();
			}
			
		},
		error: errorMsg
		
	});
}

//에러 메세지
function errorMsg(request, status, error) {
	alert("요청실패")
	console.log(request.status)
	console.log(request.responseText)
	console.log(error)
}

//input내 비어있는 값 추출
function isEmpty(str){
	return str == "" || str == null || typeof str == undefined;
}

