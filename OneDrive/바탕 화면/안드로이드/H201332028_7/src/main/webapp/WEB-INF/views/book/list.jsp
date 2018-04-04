<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>

<body>
<div class="container">
  <h1>도시 목록</h1>
  
<form:form method="get" modelAttribute="pagination" class="form-inline mb5">
    <form:hidden path="pg" value="1" />
   
    <span>순서:</span>  
    <form:select path="sb" class="form-control ml20"
                 itemValue="value" itemLabel="label" items="${ searchBy }" />
    <form:input path="st" class="form-control" placeholder="검색문자열" value="${pagination.st}"/>
    <button type="submit" class="btn btn-default">
      <i class="glyphicon glyphicon-search"></i> 검색</button>
    <c:if test="${ pagination.sb > 0 }">
      <a class="btn btn-default" href="list?&pg=1">
        <i class="glyphicon glyphicon-ban-circle"></i> 검색취소</a>
    </c:if>

  </form:form>


  <div class="pull-right mb5">
    <a class="btn btn-primary" href="create?${ pagination.queryString }">
    <span class="glyphicon glyphicon-user"></span> 책 등록</a>
  </div>    
  <table class="table table-bordered mt5">
    <thead>
      <tr>
        <th style="text-align: center;">ID</th>
        <th>제목</th>
   		<th>저자</th>
   		<th>출판사</th>
   		<th>카테고리</th>
   		<th style="text-align: right;">가격</th>
   		
   			
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ books }">
        <tr data-url="edit.do?id=${ book.id }&${ pagination.queryString }">
          <td style="text-align: center;">${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <td>${ book.publisher.publisherTitle }</td>
          <td>${ book.category.categoryName }</td>
           <td style="text-align: right;">${ book.price }</td>
        
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="15" recordCount="${ pagination.recordCount }" />
</div>
</body>
</html>

