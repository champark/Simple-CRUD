<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
    <h2>메모 리스트</h2>
    <ul>
        <c:forEach var="memo" items="${memos}">
            <li>
                <span>${memo.content}</span>
                <a href="/memos/${memo.id}/edit">수정</a> |
                <a href="/memos/${memo.id}/delete">삭제</a>
            </li>
        </c:forEach>
    </ul>
    <a href="/memos/new">새 메모 작성</a>
</section>
