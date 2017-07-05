/**
 * 자바스크립트 소스 파일 : 파일명.js 
 * <script></script> 태그를 사용하지 않음.
 */

function testFunc1() {
	//window 객체만 생략할 수 있음
	alert("경고창을 출력하도록 하였습니다.\n"
		+ typeof("apple") + ", " + typeof('banana')+ ", " + typeof(123) + ", " + typeof(3.14) + "\n" + typeof(12 + "3")
		+ "\n"+ typeof(3 == 4) + "\n" +typeof('A')  + ", " + typeof(num));
}

function showAlert() {
	alert("메세지만 출력하는 알림창입니다.");
}

function showConfirm() {
	var returnValue = confirm("살거면 확인, 안 살거면 취소");
	document.getElementById("box1").innerHTML = "구매의사 : " + (returnValue == true ? "구매함" : "구매안함");
}

function showPrompt() {
	var returnValue = prompt("주소를 입력하세요.");
	document.getElementById("box1").innerHTML += "<br>입력된 주소 : " + returnValue;
}

function calculator() {
	var n1 = document.getElementById("num1").value;
	var n2 = document.getElementById("num2").value;
	//문자열 값을 숫자로 바꾸는 함수 사용 : Number(값)
	var result = Number(n1) + Number(n2);
	document.getElementById("result").value = result;
	console.log(typeof(Number(n1)) + ", " + typeof(Number(n2)));
}

function calculator2(op) {
	var n1 = Number(document.getElementById("value1").value);
	var n2 = Number(document.getElementById("value2").value);
	var result = n1 + n2 ;
	
	switch(op){
	case '+' : result = n1 + n2; break;
	case '-' : result = n1 - n2; break;
	case '*' : result = n1 * n2; break;
	case '/' : result = n1 / n2; break;
	case '%' : result = n1 % n2; break;

	}
	
	document.getElementById("box2").innerHTML = result;
}

function check() {
	alert(" 비교연산자 ==  확인 : " + ('' == false) + ", " 
		+ ('' == 0) + ", " + (0 == false) + ", " 
		+ ('273' == 273) + "\n" +
		"비교연산자 === 확인 : " + ('' === false) + ", " 
		+ ('' === 0) + ", " + (0 === false) + ", " 
		+ ('273' === 273));
} 

function checkSwitch() {
	var today = new Date();
	var currentHour = today.getHours();

	switch(true){
	case currentHour == 9: 
		alert("업무 시작 시간입니다."); break;
	case currentHour < 11 : 
		alert("오전 간식 시간입니다."); break;
	case currentHour < 15: 
		alert("오후 간식 시간입니다."); break;
	case currentHour > 18 : 
		alert("퇴근 시간입니다."); break;

	default: alert("일할 시간입니다."); break;
	}
	
}

function checkLogic() {
	var input = Number(prompt("숫자를 입력하시오."));

	//짧은 조건문 : ||는 앞이 거짓이면 뒤를 실행, 
	//					 &&는 앞이 참이면 뒤를 실행함 
	input % 2 == 0 || alert("홀수 입니다.");
	input % 2 == 0 && alert("짝수 입니다.");
}