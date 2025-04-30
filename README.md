

도서홈페이지
https://wikibook.co.kr/vue3-springboot


예제코드
https://github.com/wikibook/vue3-springboot

````javascript
fetch("/v1/api/account/login", {
headers: { "Content-Type": "application/json;charset=utf-8" },
method: "POST",
body: JSON.stringify({
loginId: "alpha@example.com",
loginPw: "password111",
})
}).then(res => console.log(res.status));
````

