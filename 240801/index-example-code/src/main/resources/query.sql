SELECT (count(member_id))
FROM member;

--  복합 Index 사용
SELECT member_id, email, name, phone
FROM member
WHERE phone = '010-12341'
  AND email = '12341@gmail.com';

--  Index 미사용
SELECT member_id, email, name, phone
FROM member
WHERE phone = '010-12341'
   OR email = '2341@gmail.com';

--  먼저 선언한 Index 로 조회시 Index 사용
SELECT member_id, email, name, phone
FROM member
WHERE phone = '010-2341';

--  먼저 선언한 Index 로 조회시 Index 미사용
SELECT member_id, email, name, phone
FROM member
WHERE email = '2341@gmail.com';