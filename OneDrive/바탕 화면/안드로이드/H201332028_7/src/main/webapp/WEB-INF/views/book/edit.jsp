<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
  <h1>도서 ${ title }</h1>
  <form:form method="post" modelAttribute="book">

    <div class="form-group">
      <label>제목:</label>
      <form:input path="title" class="form-control w200" />
    </div>
     <div class="form-group">
      <label>저자:</label>
      <form:input path="author" class="form-control w200" />
    </div>
     <div class="form-group">
      <label>가격:</label>
      <form:input path="price" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>카테고리</label>
      <form:select path="category.id" class="form-control w200"
                   itemValue="id" itemLabel="categoryName" items="${ categorys }" />
    </div>
     <div class="form-group">
      <label>출판사</label>
      <form:select path="publisher.id" class="form-control w200"
                   itemValue="id" itemLabel="publisherTitle" items="${ publishers }" />
    </div>
    
    <hr/>
    
    
    <button type="submit" class="btn btn-primary">
      <i class="glyphicon glyphicon-ok"></i> 저장
    </button>
    
    <a class="btn btn-default" href="list?${ pagination.queryString }">
      <i class="glyphicon glyphicon-list"></i> 목록으로
    </a>
  </form:form>

</div>
</body>
</html>
