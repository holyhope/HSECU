<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="header" />
<%
    String base_url = "./";
    String base_scripts_url = "./scripts";
    String base_styles_url = "./styles";
%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <script src="<%=base_scripts_url%>/jquery-2.1.4.min.js"></script>

        <link rel="stylesheet" href="<%=base_styles_url%>/bootstrap.min.css" />
        <script src="<%=base_scripts_url%>/bootstrap.min.js"></script>

        <link rel="stylesheet" href="<%=base_styles_url%>/template.css" />

        <title>HSECU - Consultation</title>
        <title><fmt:message key="window_title" /> -
            ${param.window_title}</title>

        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    </head>
    <body>
        <div class="container">