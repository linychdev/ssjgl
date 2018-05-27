<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head> 
  <title>Home</title> 
  <meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1" /> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
  <meta name="keywords" content="Optometry Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> 
  <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" /> 
  <!-- //js --> 
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/layer/layer.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <script src="${pageContext.request.contextPath}/js/index.js"></script>
  <script src="${pageContext.request.contextPath}/js/holder.js"></script>
  <script src="${pageContext.request.contextPath}/js/default.js"></script>
  <script type="text/javascript">
  	var contextPath = "<%=request.getContextPath()%>";
  </script>
 </head> 
 <body> 
  <jsp:include page="/header.jsp" flush="true" />
  <!-- 主体开始 --> 
  <div class="main container"> 
   <!-- 搜索框 --> 
   <div class="row"> 
    <div class="col-md-12 removePadding"> 
     <div class="input-group" style="width:100%; margin-top:5px;"> 
      <input type="text" class="form-control input-lg" placeholder="please input elements" />
      <span class="input-group-addon btn btn-success">search</span> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="H"> 
        <div class="atomic fontYellow">
         1
        </div> 
        <div class="crystal fontYellow">
          hcp 
        </div> 
        <div class="symbol fontYellow">
          H 
        </div> 
        <div class="element-name fontYellow">
          Hydrogen 
        </div> 
        <span class="show-span oxidation">-1,+1</span> 
        <span class="show-span electron">1s<sup>1</sup></span> 
        <span class="show-span eleativity">2.2</span> 
        <span class="show-span ionic">13.6</span> 
        <span class="show-span boiling">-253</span> 
        <span class="show-span melting">-259</span> 
        <span class="show-span relative">1.0</span> 
        <span class="show-span radius">37</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4 col-md-offset-4"> 
     <div class="row"> 
      <div class="col-md-2 col-md-offset-10"> 
       <div class="elements" id="He"> 
        <div class="atomic fontGreen">
         2
        </div> 
        <div class="crystal fontGreen">
          hcp 
        </div> 
        <div class="symbol fontGreen">
          He 
        </div> 
        <div class="element-name fontGreen">
          Helium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">1s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">24.6</span> 
        <span class="show-span boiling">-269</span> 
        <span class="show-span melting">-272</span> 
        <span class="show-span relative">4.0</span> 
        <span class="show-span radius">32</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第一行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Li"> 
        <div class="atomic fontYellow">
         3
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          Li 
        </div> 
        <div class="element-name fontYellow">
          Lithium 
        </div> 
        <span class="show-span oxidation">+1</span> 
        <span class="show-span electron">[He]2s<sup>1</sup></span> 
        <span class="show-span eleativity">1.0</span> 
        <span class="show-span ionic">5.4</span> 
        <span class="show-span boiling">134</span> 
        <span class="show-span melting">181</span> 
        <span class="show-span relative">6.9</span> 
        <span class="show-span radius">152</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Be"> 
        <div class="atomic fontYellow">
         4
        </div> 
        <div class="crystal fontYellow ">
          hcp 
        </div> 
        <div class="symbol fontYellow">
          Be 
        </div> 
        <div class="element-name fontYellow">
          Berylium 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[He]2s<sup>2</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">4.3</span> 
        <span class="show-span boiling">2471</span> 
        <span class="show-span melting">1287</span> 
        <span class="show-span relative">9.0</span> 
        <span class="show-span radius">112</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4 col-md-offset-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="B"> 
        <div class="atomic fontPink">
         5
        </div> 
        <div class="crystal fontPink ">
          hcp 
        </div> 
        <div class="symbol fontPink">
          B 
        </div> 
        <div class="element-name fontPink">
          Boron 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[He]2s<sup>2</sup>2p<sup>1</sup></span> 
        <span class="show-span eleativity">2.0</span> 
        <span class="show-span ionic">8.3</span> 
        <span class="show-span boiling">4000</span> 
        <span class="show-span melting">2075</span> 
        <span class="show-span relative">10.8</span> 
        <span class="show-span radius">85</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="C"> 
        <div class="atomic fontPink">
         6
        </div> 
        <div class="crystal fontPink">
          hcp 
        </div> 
        <div class="symbol fontPink">
          C 
        </div> 
        <div class="element-name fontPink">
          Carbon 
        </div> 
        <span class="show-span oxidation">-4,+4,+2</span> 
        <span class="show-span electron">[He]2s<sup>2</sup>2p<sup>2</sup></span> 
        <span class="show-span eleativity">2.5</span> 
        <span class="show-span ionic">11.3</span> 
        <span class="show-span boiling">3642</span> 
        <span class="show-span melting">4492</span> 
        <span class="show-span relative">12.0</span> 
        <span class="show-span radius">77</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="N"> 
        <div class="atomic fontPink">
         7
        </div> 
        <div class="crystal fontPink">
          hcp 
        </div> 
        <div class="symbol fontPink">
          N 
        </div> 
        <div class="element-name fontPink">
          Nitrogen 
        </div> 
        <span class="show-span oxidation">-3,-2,-1,+1,+2,+3,+4,+5</span> 
        <span class="show-span electron">[He]2s<sup>2</sup>2p<sup>3</sup></span> 
        <span class="show-span eleativity">3.1</span> 
        <span class="show-span ionic">14.5</span> 
        <span class="show-span boiling">-196</span> 
        <span class="show-span melting">-210</span> 
        <span class="show-span relative">14.0</span> 
        <span class="show-span radius">75</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="O"> 
        <div class="atomic fontPink">
         8
        </div> 
        <div class="crystal fontPink">
          hcp 
        </div> 
        <div class="symbol fontPink">
          O 
        </div> 
        <div class="element-name fontPink">
          Oxygen 
        </div> 
        <span class="show-span oxidation">-2,-1</span> 
        <span class="show-span electron">[He]2s<sup>2</sup>2p<sup>4</sup></span> 
        <span class="show-span eleativity">3.5</span> 
        <span class="show-span ionic">13.6</span> 
        <span class="show-span boiling">-183</span> 
        <span class="show-span melting">-219</span> 
        <span class="show-span relative">16.0</span> 
        <span class="show-span radius">73</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="F"> 
        <div class="atomic fontPink">
         9
        </div> 
        <div class="crystal fontPink hid"> 
        </div> 
        <div class="symbol fontPink">
          F 
        </div> 
        <div class="element-name fontPink">
          Fluorine 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[He]2s<sup>2</sup>2p<sup>5</sup></span> 
        <span class="show-span eleativity">4.1</span> 
        <span class="show-span ionic">17.4</span> 
        <span class="show-span boiling">-188</span> 
        <span class="show-span melting">-220</span> 
        <span class="show-span relative">19.0</span> 
        <span class="show-span radius">71</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ne"> 
        <div class="atomic fontGreen">
         10
        </div> 
        <div class="crystal fontGreen ">
          fcc 
        </div> 
        <div class="symbol fontGreen">
          Ne 
        </div> 
        <div class="element-name fontGreen">
          Neon 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[He]2s<sup>2</sup>2p<sup>6</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">21.6</span> 
        <span class="show-span boiling">-246</span> 
        <span class="show-span melting">-249</span> 
        <span class="show-span relative">20.2</span> 
        <span class="show-span radius">69</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第二行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Na"> 
        <div class="atomic fontYellow">
         11
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          Na 
        </div> 
        <div class="element-name fontYellow">
          Sodium 
        </div> 
        <span class="show-span oxidation">+1</span> 
        <span class="show-span electron">[Ne]3s<sup>1</sup></span> 
        <span class="show-span eleativity">1.0</span> 
        <span class="show-span ionic">5.1</span> 
        <span class="show-span boiling">883</span> 
        <span class="show-span melting">98</span> 
        <span class="show-span relative">23.0</span> 
        <span class="show-span radius">186</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Mg"> 
        <div class="atomic fontYellow">
         12
        </div> 
        <div class="crystal fontYellow">
          hcp 
        </div> 
        <div class="symbol fontYellow">
          Mg 
        </div> 
        <div class="element-name fontYellow">
          Magenesium 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">7.6</span> 
        <span class="show-span boiling">1090</span> 
        <span class="show-span melting">650</span> 
        <span class="show-span relative">24.3</span> 
        <span class="show-span radius">160</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4 col-md-offset-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Al"> 
        <div class="atomic ">
         13
        </div> 
        <div class="crystal">
          fcc 
        </div> 
        <div class="symbol">
          Al 
        </div> 
        <div class="element-name">
          Aluminum 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup>3p<sup>1</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">6.0</span> 
        <span class="show-span boiling">2519</span> 
        <span class="show-span melting">660</span> 
        <span class="show-span relative">27.0</span> 
        <span class="show-span radius">143</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Si"> 
        <div class="atomic fontPink">
         14
        </div> 
        <div class="crystal fontPink">
          diamand 
        </div> 
        <div class="symbol fontPink">
          Si 
        </div> 
        <div class="element-name fontPink">
          Silicon 
        </div> 
        <span class="show-span oxidation">-4,+2,+4</span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup>3p<sup>2</sup></span> 
        <span class="show-span eleativity">1.7</span> 
        <span class="show-span ionic">8.2</span> 
        <span class="show-span boiling">3265</span> 
        <span class="show-span melting">1414</span> 
        <span class="show-span relative">28.1</span> 
        <span class="show-span radius">111</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="P"> 
        <div class="atomic fontPink">
         15
        </div> 
        <div class="crystal fontPink ">
          cubic 
        </div> 
        <div class="symbol fontPink">
          P 
        </div> 
        <div class="element-name fontPink">
          Phosphorus 
        </div> 
        <span class="show-span oxidation">-3,-2,+1,+3,+5</span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup>3p<sup>3</sup></span> 
        <span class="show-span eleativity">2.1</span> 
        <span class="show-span ionic">10.5</span> 
        <span class="show-span boiling">281</span> 
        <span class="show-span melting">44</span> 
        <span class="show-span relative">31.0</span> 
        <span class="show-span radius">106</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="S"> 
        <div class="atomic fontPink">
         16
        </div> 
        <div class="crystal fontPink">
          cubic 
        </div> 
        <div class="symbol fontPink">
          S 
        </div> 
        <div class="element-name fontPink">
          Sulfur 
        </div> 
        <span class="show-span oxidation">-2,+2,+4,+6</span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup>3p<sup>4</sup></span> 
        <span class="show-span eleativity">2.4</span> 
        <span class="show-span ionic">10.4</span> 
        <span class="show-span boiling">445</span> 
        <span class="show-span melting">115</span> 
        <span class="show-span relative">32.1</span> 
        <span class="show-span radius">102</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Cl"> 
        <div class="atomic fontPink">
         17
        </div> 
        <div class="crystal fontPink">
          tetragonal 
        </div> 
        <div class="symbol fontPink">
          Cl 
        </div> 
        <div class="element-name fontPink">
          Chlorine 
        </div> 
        <span class="show-span oxidation">-1,+1,+3,+5,+7</span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup>3p<sup>5</sup></span> 
        <span class="show-span eleativity">2.8</span> 
        <span class="show-span ionic">13.0</span> 
        <span class="show-span boiling">-34</span> 
        <span class="show-span melting">-102</span> 
        <span class="show-span relative">35.5</span> 
        <span class="show-span radius">99</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ar"> 
        <div class="atomic fontGreen">
         18
        </div> 
        <div class="crystal fontGreen">
          fcc 
        </div> 
        <div class="symbol fontGreen">
          Ar 
        </div> 
        <div class="element-name fontGreen">
          Argon 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Ne]3s<sup>2</sup>3p<sup>6</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">15.8</span> 
        <span class="show-span boiling">-186</span> 
        <span class="show-span melting">-189</span> 
        <span class="show-span relative">39.9</span> 
        <span class="show-span radius">97</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第三行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="K"> 
        <div class="atomic fontYellow">
         19
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          K 
        </div> 
        <div class="element-name fontYellow">
          Potassium 
        </div> 
        <span class="show-span oxidation">+1</span> 
        <span class="show-span electron">[Ar]4s<sup>1</sup></span> 
        <span class="show-span eleativity">0.9</span> 
        <span class="show-span ionic">4.3</span> 
        <span class="show-span boiling">759</span> 
        <span class="show-span melting">63</span> 
        <span class="show-span relative">39.1</span> 
        <span class="show-span radius">227</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ca"> 
        <div class="atomic fontYellow">
         20
        </div> 
        <div class="crystal fontYellow">
          fcc 
        </div> 
        <div class="symbol fontYellow">
          Ca 
        </div> 
        <div class="element-name fontYellow">
          Calcuium 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Ar]4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.0</span> 
        <span class="show-span ionic">6.1</span> 
        <span class="show-span boiling">1484</span> 
        <span class="show-span melting">842</span> 
        <span class="show-span relative">40.1</span> 
        <span class="show-span radius">197</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Sc"> 
        <div class="atomic ">
         21
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol">
          Sc 
        </div> 
        <div class="element-name">
          Scandium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Ar]3d<sup>1</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.3</span> 
        <span class="show-span ionic">6.6</span> 
        <span class="show-span boiling">2830</span> 
        <span class="show-span melting">1541</span> 
        <span class="show-span relative">45.0</span> 
        <span class="show-span radius">162</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ti"> 
        <div class="atomic ">
         22
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol">
          Ti 
        </div> 
        <div class="element-name">
          Titanium 
        </div> 
        <span class="show-span oxidation">-1,0,+2,+3,+4</span> 
        <span class="show-span electron">[Ar]3d<sup>2</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.6</span> 
        <span class="show-span ionic">6.8</span> 
        <span class="show-span boiling">3287</span> 
        <span class="show-span melting">1668</span> 
        <span class="show-span relative">47.9</span> 
        <span class="show-span radius">147</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="V"> 
        <div class="atomic ">
         23
        </div> 
        <div class="crystal">
          bcc 
        </div> 
        <div class="symbol ">
          V 
        </div> 
        <div class="element-name ">
          Vanadium 
        </div> 
        <span class="show-span oxidation">-1,0,+1,+2,+3,+4,+5</span> 
        <span class="show-span electron">[Ar]3d<sup>3</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">6.7</span> 
        <span class="show-span boiling">3407</span> 
        <span class="show-span melting">1910</span> 
        <span class="show-span relative">50.9</span> 
        <span class="show-span radius">134</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Cr"> 
        <div class="atomic ">
         24
        </div> 
        <div class="crystal">
          bcc 
        </div> 
        <div class="symbol">
          Cr 
        </div> 
        <div class="element-name">
          Chromium 
        </div> 
        <span class="show-span oxidation">-3,-2,-1,0,+1,+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Ar]3d<sup>5</sup>4s<sup>1</sup></span> 
        <span class="show-span eleativity">1.6</span> 
        <span class="show-span ionic">6.8</span> 
        <span class="show-span boiling">2671</span> 
        <span class="show-span melting">1907</span> 
        <span class="show-span relative">52.0</span> 
        <span class="show-span radius">128</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Mn"> 
        <div class="atomic ">
         25
        </div> 
        <div class="crystal">
          cubic 
        </div> 
        <div class="symbol">
          Mn 
        </div> 
        <div class="element-name ">
          Manganese 
        </div> 
        <span class="show-span oxidation">-3,-2,-1,0,+1,+2,+3,+4,+5,+6,+7</span> 
        <span class="show-span electron">[Ar]3d<sup>5</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.6</span> 
        <span class="show-span ionic">7.4</span> 
        <span class="show-span boiling">2061</span> 
        <span class="show-span melting">1246</span> 
        <span class="show-span relative">54.9</span> 
        <span class="show-span radius">127</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Fe"> 
        <div class="atomic ">
         26
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Fe 
        </div> 
        <div class="element-name">
          Iron 
        </div> 
        <span class="show-span oxidation">-2,-1,0,+1,+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Ar]3d<sup>6</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.6</span> 
        <span class="show-span ionic">7.9</span> 
        <span class="show-span boiling">2861</span> 
        <span class="show-span melting">1538</span> 
        <span class="show-span relative">55.8</span> 
        <span class="show-span radius">126</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Co"> 
        <div class="atomic ">
         27
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol">
          Co 
        </div> 
        <div class="element-name">
          Cobalt 
        </div> 
        <span class="show-span oxidation">-1,0,+1,+2,+3,+4,+5</span> 
        <span class="show-span electron">[Ar]3d<sup>7</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.7</span> 
        <span class="show-span ionic">7.9</span> 
        <span class="show-span boiling">2927</span> 
        <span class="show-span melting">1495</span> 
        <span class="show-span relative">58.9</span> 
        <span class="show-span radius">125</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ni"> 
        <div class="atomic ">
         28
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Ni 
        </div> 
        <div class="element-name">
          Nickel 
        </div> 
        <span class="show-span oxidation">-1,0,+1,+2,+3,+4</span> 
        <span class="show-span electron">[Ar]3d<sup>8</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.8</span> 
        <span class="show-span ionic">7.6</span> 
        <span class="show-span boiling">2913</span> 
        <span class="show-span melting">1455</span> 
        <span class="show-span relative">58.7</span> 
        <span class="show-span radius">124</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Cu"> 
        <div class="atomic ">
         29
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Cu 
        </div> 
        <div class="element-name ">
          Copper 
        </div> 
        <span class="show-span oxidation">+1,+2,+3,+4</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>1</sup></span> 
        <span class="show-span eleativity">1.8</span> 
        <span class="show-span ionic">7.7</span> 
        <span class="show-span boiling">2562</span> 
        <span class="show-span melting">1085</span> 
        <span class="show-span relative">63.5</span> 
        <span class="show-span radius">128</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Zn"> 
        <div class="atomic ">
         30
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Zn 
        </div> 
        <div class="element-name ">
          Zinc 
        </div> 
        <span class="show-span oxidation">+1,+2</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup></span> 
        <span class="show-span eleativity">1.7</span> 
        <span class="show-span ionic">9.4</span> 
        <span class="show-span boiling">907</span> 
        <span class="show-span melting">420</span> 
        <span class="show-span relative">65.4</span> 
        <span class="show-span radius">134</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Ga"> 
        <div class="atomic ">
         31
        </div> 
        <div class="crystal ">
          cubic 
        </div> 
        <div class="symbol ">
          Ga 
        </div> 
        <div class="element-name ">
          Gallium 
        </div> 
        <span class="show-span oxidation">+1,+3</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup>4p<sup>1</sup></span> 
        <span class="show-span eleativity">1.8</span> 
        <span class="show-span ionic">6.0</span> 
        <span class="show-span boiling">2204</span> 
        <span class="show-span melting">30</span> 
        <span class="show-span relative">69.7</span> 
        <span class="show-span radius">135</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ge"> 
        <div class="atomic ">
         32
        </div> 
        <div class="crystal ">
          diamand 
        </div> 
        <div class="symbol ">
          Ge 
        </div> 
        <div class="element-name ">
          Germanium 
        </div> 
        <span class="show-span oxidation">+2,+4</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup>4p<sup>2</sup></span> 
        <span class="show-span eleativity">2.0</span> 
        <span class="show-span ionic">7.9</span> 
        <span class="show-span boiling">2833</span> 
        <span class="show-span melting">938</span> 
        <span class="show-span relative">72.6</span> 
        <span class="show-span radius">122</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="As"> 
        <div class="atomic fontPink">
         33
        </div> 
        <div class="crystal fontPink ">
          trigonal 
        </div> 
        <div class="symbol fontPink">
          As 
        </div> 
        <div class="element-name fontPink">
          Arsenic 
        </div> 
        <span class="show-span oxidation">-3,+3,+5</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup>4p<sup>3</sup></span> 
        <span class="show-span eleativity">2.2</span> 
        <span class="show-span ionic">9.8</span> 
        <span class="show-span boiling">614</span> 
        <span class="show-span melting">817</span> 
        <span class="show-span relative">74.9</span> 
        <span class="show-span radius">119</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Se"> 
        <div class="atomic fontPink">
         34
        </div> 
        <div class="crystal fontPink">
          hcp 
        </div> 
        <div class="symbol fontPink">
          Se 
        </div> 
        <div class="element-name fontPink">
          Selenium 
        </div> 
        <span class="show-span oxidation">-2,+2,+4,+6</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup>4p<sup>4</sup></span> 
        <span class="show-span eleativity">2.5</span> 
        <span class="show-span ionic">9.8</span> 
        <span class="show-span boiling">685</span> 
        <span class="show-span melting">221</span> 
        <span class="show-span relative">79.0</span> 
        <span class="show-span radius">116</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Br"> 
        <div class="atomic fontPink">
         35
        </div> 
        <div class="crystal fontPink">
          cubic 
        </div> 
        <div class="symbol fontPink">
          Br 
        </div> 
        <div class="element-name fontPink">
          Bromine 
        </div> 
        <span class="show-span oxidation">-1,+1,+3,+5,+7</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup>4p<sup>5</sup></span> 
        <span class="show-span eleativity">2.8</span> 
        <span class="show-span ionic">11.8</span> 
        <span class="show-span boiling">59</span> 
        <span class="show-span melting">-7</span> 
        <span class="show-span relative">79.9</span> 
        <span class="show-span radius">114</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Kr"> 
        <div class="atomic fontGreen">
         36
        </div> 
        <div class="crystal fontGreen">
          fcc 
        </div> 
        <div class="symbol fontGreen">
          Kr 
        </div> 
        <div class="element-name fontGreen">
          Krypton 
        </div> 
        <span class="show-span oxidation">+2,+4</span> 
        <span class="show-span electron">[Ar]3d<sup>10</sup>4s<sup>2</sup>4p<sup>6</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">14.0</span> 
        <span class="show-span boiling">-153</span> 
        <span class="show-span melting">-157</span> 
        <span class="show-span relative">83.8</span> 
        <span class="show-span radius">110</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第四行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Rb"> 
        <div class="atomic fontYellow">
         37
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          Rb 
        </div> 
        <div class="element-name fontYellow">
          Rubidum 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Kr]5s<sup>1</sup></span> 
        <span class="show-span eleativity">0.9</span> 
        <span class="show-span ionic">4.2</span> 
        <span class="show-span boiling">688</span> 
        <span class="show-span melting">39</span> 
        <span class="show-span relative">85.5</span> 
        <span class="show-span radius">248</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Sr"> 
        <div class="atomic fontYellow">
         38
        </div> 
        <div class="crystal fontYellow">
          fcc 
        </div> 
        <div class="symbol fontYellow">
          Sr 
        </div> 
        <div class="element-name fontYellow">
          Strontium 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Kr]5s<sup>2</sup></span> 
        <span class="show-span eleativity">1.0</span> 
        <span class="show-span ionic">5.7</span> 
        <span class="show-span boiling">1382</span> 
        <span class="show-span melting">777</span> 
        <span class="show-span relative">87.6</span> 
        <span class="show-span radius">215</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Y"> 
        <div class="atomic">
         39
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Y 
        </div> 
        <div class="element-name">
          Yttrium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Kr]4d<sup>1</sup>5s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.2</span> 
        <span class="show-span boiling">3336</span> 
        <span class="show-span melting">1526</span> 
        <span class="show-span relative">88.9</span> 
        <span class="show-span radius">180</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Zr"> 
        <div class="atomic ">
         40
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol">
          Zr 
        </div> 
        <div class="element-name">
          Zirconium 
        </div> 
        <span class="show-span oxidation">+1,+2,+3,+4</span> 
        <span class="show-span electron">[Kr]4d<sup>2</sup>5s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.6</span> 
        <span class="show-span boiling">4409</span> 
        <span class="show-span melting">1855</span> 
        <span class="show-span relative">91.2</span> 
        <span class="show-span radius">160</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Nb"> 
        <div class="atomic ">
         41
        </div> 
        <div class="crystal ">
          bcc 
        </div> 
        <div class="symbol ">
          Nb 
        </div> 
        <div class="element-name ">
          Niobium 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,+2,+3,+4,+5</span> 
        <span class="show-span electron">[Kr]4d<sup>4</sup>5s<sup>1</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.8</span> 
        <span class="show-span boiling">4744</span> 
        <span class="show-span melting">2477</span> 
        <span class="show-span relative">92.9</span> 
        <span class="show-span radius">146</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Mo"> 
        <div class="atomic ">
         42
        </div> 
        <div class="crystal ">
          bcc 
        </div> 
        <div class="symbol">
          Mo 
        </div> 
        <div class="element-name ">
          Molybdenum 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,&plusmn;2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Kr]4d<sup>5</sup>5s<sup>1</sup></span> 
        <span class="show-span eleativity">1.3</span> 
        <span class="show-span ionic">7.1</span> 
        <span class="show-span boiling">4639</span> 
        <span class="show-span melting">2623</span> 
        <span class="show-span relative">95.9</span> 
        <span class="show-span radius">139</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Tc"> 
        <div class="atomic ">
         43
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Tc 
        </div> 
        <div class="element-name ">
          Technetium 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,+2,+3,+4,+5,+6,+7</span> 
        <span class="show-span electron">[Kr]4d<sup>5</sup>5s<sup>2</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">7.3</span> 
        <span class="show-span boiling">4265</span> 
        <span class="show-span melting">2157</span> 
        <span class="show-span relative">97.9</span> 
        <span class="show-span radius">136</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ru"> 
        <div class="atomic ">
         44
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Ru 
        </div> 
        <div class="element-name ">
          Ruthenium 
        </div> 
        <span class="show-span oxidation">0,+1,&plusmn;2,+3,+4,+5,+6,+7,+8</span> 
        <span class="show-span electron">[Kr]4d<sup>7</sup>5s<sup>1</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling">4150</span> 
        <span class="show-span melting">2334</span> 
        <span class="show-span relative">101.1</span> 
        <span class="show-span radius">134</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Rh"> 
        <div class="atomic ">
         45
        </div> 
        <div class="crystal">
          fcc 
        </div> 
        <div class="symbol ">
          Rh 
        </div> 
        <div class="element-name ">
          Rhodium 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Kr]4d<sup>8</sup>5s<sup>1</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">7.5</span> 
        <span class="show-span boiling">3695</span> 
        <span class="show-span melting">1964</span> 
        <span class="show-span relative">102.9</span> 
        <span class="show-span radius">134</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pd"> 
        <div class="atomic ">
         46
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Pd 
        </div> 
        <div class="element-name ">
          Palladium 
        </div> 
        <span class="show-span oxidation">0,+1,+2,+3,+4</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">8.3</span> 
        <span class="show-span boiling">2963</span> 
        <span class="show-span melting">1555</span> 
        <span class="show-span relative">106.4</span> 
        <span class="show-span radius">137</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ag"> 
        <div class="atomic ">
         47
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Ag 
        </div> 
        <div class="element-name ">
          Sliver 
        </div> 
        <span class="show-span oxidation">+1,+2,+3</span> 
        <span class="show-span electron">[kr]4d<sup>10</sup>5s<sup>1</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">7.6</span> 
        <span class="show-span boiling">2161</span> 
        <span class="show-span melting">962</span> 
        <span class="show-span relative">107.9</span> 
        <span class="show-span radius">144</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Cd"> 
        <div class="atomic ">
         48
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Cd 
        </div> 
        <div class="element-name ">
          Cadmium 
        </div> 
        <span class="show-span oxidation">+1,+2</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s<sup>2</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">9.0</span> 
        <span class="show-span boiling">767</span> 
        <span class="show-span melting">321</span> 
        <span class="show-span relative">112.4</span> 
        <span class="show-span radius">151</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="In"> 
        <div class="atomic ">
         49
        </div> 
        <div class="crystal ">
          tetragonal 
        </div> 
        <div class="symbol ">
          In 
        </div> 
        <div class="element-name ">
          Indium 
        </div> 
        <span class="show-span oxidation">+1,+3</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s<sup>2</sup>5p<sup>1</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">5.8</span> 
        <span class="show-span boiling">2072</span> 
        <span class="show-span melting">157</span> 
        <span class="show-span relative">114.8</span> 
        <span class="show-span radius">167</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Sn"> 
        <div class="atomic ">
         50
        </div> 
        <div class="crystal ">
          tetragonal 
        </div> 
        <div class="symbol ">
          Sn 
        </div> 
        <div class="element-name ">
          Tin 
        </div> 
        <span class="show-span oxidation">+2,+4</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s25p<sup>2</sup></span> 
        <span class="show-span eleativity">1.7</span> 
        <span class="show-span ionic">7.3</span> 
        <span class="show-span boiling">2602</span> 
        <span class="show-span melting">232</span> 
        <span class="show-span relative">118.7</span> 
        <span class="show-span radius">141</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Sb"> 
        <div class="atomic ">
         51
        </div> 
        <div class="crystal ">
          trigonal 
        </div> 
        <div class="symbol ">
          Sb 
        </div> 
        <div class="element-name ">
          Antimony 
        </div> 
        <span class="show-span oxidation">-3,+3,+5</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s<sup>2</sup>5p<sup>3</sup></span> 
        <span class="show-span eleativity">1.8</span> 
        <span class="show-span ionic">8.6</span> 
        <span class="show-span boiling">1587</span> 
        <span class="show-span melting">631</span> 
        <span class="show-span relative">121.8</span> 
        <span class="show-span radius">138</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Te"> 
        <div class="atomic fontPink">
         52
        </div> 
        <div class="crystal fontPink ">
          hcp 
        </div> 
        <div class="symbol fontPink">
          Te 
        </div> 
        <div class="element-name fontPink">
          Tellurium 
        </div> 
        <span class="show-span oxidation">+2,+4,+6</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s<sup>2</sup>5p<sup>4</sup></span> 
        <span class="show-span eleativity">2.0</span> 
        <span class="show-span ionic">9.0</span> 
        <span class="show-span boiling">988</span> 
        <span class="show-span melting">450</span> 
        <span class="show-span relative">127.6</span> 
        <span class="show-span radius">135</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="I"> 
        <div class="atomic fontPink">
         53
        </div> 
        <div class="crystal fontPink ">
          cubic 
        </div> 
        <div class="symbol fontPink">
          I 
        </div> 
        <div class="element-name fontPink">
          Iodine 
        </div> 
        <span class="show-span oxidation">-1,+1,+3,+5,+7</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s<sup>2</sup>5p<sup>5</sup></span> 
        <span class="show-span eleativity">2.2</span> 
        <span class="show-span ionic">10.5</span> 
        <span class="show-span boiling">184</span> 
        <span class="show-span melting">114</span> 
        <span class="show-span relative">126.9</span> 
        <span class="show-span radius">133</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Xe"> 
        <div class="atomic fontGreen">
         54
        </div> 
        <div class="crystal fontGreen">
          fcc 
        </div> 
        <div class="symbol fontGreen">
          Xe 
        </div> 
        <div class="element-name fontGreen">
          Xenon 
        </div> 
        <span class="show-span oxidation">+2,+4,+6,+8</span> 
        <span class="show-span electron">[Kr]4d<sup>10</sup>5s<sup>2</sup>5p<sup>6</sup></span> 
        <span class="show-span eleativity">2.2</span> 
        <span class="show-span ionic">12.1</span> 
        <span class="show-span boiling">-108</span> 
        <span class="show-span melting">-112</span> 
        <span class="show-span relative">131.3</span> 
        <span class="show-span radius">130</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第五行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Cs"> 
        <div class="atomic fontYellow">
         55
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          Cs 
        </div> 
        <div class="element-name fontYellow">
          Cesium 
        </div> 
        <span class="show-span oxidation">+1</span> 
        <span class="show-span electron">[Xe]6s<sup>1</sup></span> 
        <span class="show-span eleativity">0.9</span> 
        <span class="show-span ionic">3.9</span> 
        <span class="show-span boiling">671</span> 
        <span class="show-span melting">28</span> 
        <span class="show-span relative">132.9</span> 
        <span class="show-span radius">265</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ba"> 
        <div class="atomic fontYellow">
         56
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          Ba 
        </div> 
        <div class="element-name fontYellow">
          Barium 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Xe]6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.0</span> 
        <span class="show-span ionic">5.2</span> 
        <span class="show-span boiling">1897</span> 
        <span class="show-span melting">727</span> 
        <span class="show-span relative">137.3</span> 
        <span class="show-span radius">222</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Hf"> 
        <div class="atomic ">
         72
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Hf 
        </div> 
        <div class="element-name ">
          Hafnium 
        </div> 
        <span class="show-span oxidation">+1,+2,+3,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>2</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.8</span> 
        <span class="show-span boiling">4603</span> 
        <span class="show-span melting">2233</span> 
        <span class="show-span relative">178.5</span> 
        <span class="show-span radius">159</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ta"> 
        <div class="atomic ">
         73
        </div> 
        <div class="crystal ">
          bcc 
        </div> 
        <div class="symbol ">
          Ta 
        </div> 
        <div class="element-name ">
          Tantalium 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,+2,+3,+4,+5</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>3</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.3</span> 
        <span class="show-span ionic">7.9</span> 
        <span class="show-span boiling">5458</span> 
        <span class="show-span melting">3017</span> 
        <span class="show-span relative">180.9</span> 
        <span class="show-span radius">146</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="W"> 
        <div class="atomic ">
         74
        </div> 
        <div class="crystal ">
          bcc 
        </div> 
        <div class="symbol ">
          W 
        </div> 
        <div class="element-name ">
          Tungsten 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,&plusmn;2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>4</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">8.0</span> 
        <span class="show-span boiling">5555</span> 
        <span class="show-span melting">3422</span> 
        <span class="show-span relative">189.8</span> 
        <span class="show-span radius">139</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Re"> 
        <div class="atomic ">
         75
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Re 
        </div> 
        <div class="element-name ">
          Rhenium 
        </div> 
        <span class="show-span oxidation">0,&plusmn;1,+2,+3,+4,+5,+6,+7</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>5</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">7.9</span> 
        <span class="show-span boiling">5596</span> 
        <span class="show-span melting">3186</span> 
        <span class="show-span relative">186.2</span> 
        <span class="show-span radius">137</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Os"> 
        <div class="atomic ">
         76
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Os 
        </div> 
        <div class="element-name ">
          Osmium 
        </div> 
        <span class="show-span oxidation">0,+1,+2,+3,+4,+5,+6,+7,+8</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>6</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">8.7</span> 
        <span class="show-span boiling">5012</span> 
        <span class="show-span melting">3033</span> 
        <span class="show-span relative">190.2</span> 
        <span class="show-span radius">135</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ir"> 
        <div class="atomic ">
         77
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Ir 
        </div> 
        <div class="element-name ">
          Iridium 
        </div> 
        <span class="show-span oxidation">0,+1,+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>7</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.6</span> 
        <span class="show-span ionic">9.1</span> 
        <span class="show-span boiling">4428</span> 
        <span class="show-span melting">2446</span> 
        <span class="show-span relative">192.2</span> 
        <span class="show-span radius">136</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pt"> 
        <div class="atomic ">
         78
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Pt 
        </div> 
        <div class="element-name ">
          Platinum 
        </div> 
        <span class="show-span oxidation">0,+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d96s1</span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">9.0</span> 
        <span class="show-span boiling">3825</span> 
        <span class="show-span melting">1768</span> 
        <span class="show-span relative">195.1</span> 
        <span class="show-span radius">139</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Au"> 
        <div class="atomic ">
         79
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Au 
        </div> 
        <div class="element-name ">
          Gold 
        </div> 
        <span class="show-span oxidation">+1,+2,+3,+5</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>1</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">9.2</span> 
        <span class="show-span boiling">2856</span> 
        <span class="show-span melting">1064</span> 
        <span class="show-span relative">197.0</span> 
        <span class="show-span radius">144</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Hg"> 
        <div class="atomic ">
         80
        </div> 
        <div class="crystal ">
          trigonal 
        </div> 
        <div class="symbol ">
          Hg 
        </div> 
        <div class="element-name ">
          Mercury 
        </div> 
        <span class="show-span oxidation">+1,+2,+3</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.5</span> 
        <span class="show-span ionic">10.4</span> 
        <span class="show-span boiling">357</span> 
        <span class="show-span melting">-39</span> 
        <span class="show-span relative">200.6</span> 
        <span class="show-span radius">151</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Tl"> 
        <div class="atomic ">
         81
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Tl 
        </div> 
        <div class="element-name ">
          Thallium 
        </div> 
        <span class="show-span oxidation">+1,+3</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>6s<sup>2</sup>6p<sup>1</sup></span> 
        <span class="show-span eleativity">1.4</span> 
        <span class="show-span ionic">6.1</span> 
        <span class="show-span boiling">1473</span> 
        <span class="show-span melting">304</span> 
        <span class="show-span relative">204.4</span> 
        <span class="show-span radius">170</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pb"> 
        <div class="atomic ">
         82
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol ">
          Pb 
        </div> 
        <div class="element-name ">
          Lead 
        </div> 
        <span class="show-span oxidation">+2,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>2</sup>6p<sup>2</sup></span> 
        <span class="show-span eleativity">1.6</span> 
        <span class="show-span ionic">7.4</span> 
        <span class="show-span boiling">1749</span> 
        <span class="show-span melting">327</span> 
        <span class="show-span relative">207.2</span> 
        <span class="show-span radius">175</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Bi"> 
        <div class="atomic ">
         83
        </div> 
        <div class="crystal ">
          trigonal 
        </div> 
        <div class="symbol ">
          Bi 
        </div> 
        <div class="element-name ">
          Bismuth 
        </div> 
        <span class="show-span oxidation">-3,+3,+5</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>2</sup>6p<sup>3</sup></span> 
        <span class="show-span eleativity">1.7</span> 
        <span class="show-span ionic">7.3</span> 
        <span class="show-span boiling">1564</span> 
        <span class="show-span melting">271</span> 
        <span class="show-span relative">209.0</span> 
        <span class="show-span radius">146</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Po"> 
        <div class="atomic ">
         84
        </div> 
        <div class="crystal ">
          monoclinic 
        </div> 
        <div class="symbol ">
          Po 
        </div> 
        <div class="element-name ">
          Polonium 
        </div> 
        <span class="show-span oxidation">-2,+2,+3,+4,+6</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>2</sup>6p<sup>4</sup></span> 
        <span class="show-span eleativity">1.8</span> 
        <span class="show-span ionic">8.4</span> 
        <span class="show-span boiling">962</span> 
        <span class="show-span melting">254</span> 
        <span class="show-span relative">209.0</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="At"> 
        <div class="atomic fontPink">
         85
        </div> 
        <div class="crystal fontPink hid"> 
        </div> 
        <div class="symbol fontPink">
          At 
        </div> 
        <div class="element-name fontPink">
          Astatine 
        </div> 
        <span class="show-span oxidation">-1,+1,+5,+7</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>2</sup>6p<sup>5</sup></span> 
        <span class="show-span eleativity">2.0</span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling">337</span> 
        <span class="show-span melting">302</span> 
        <span class="show-span relative">210.0</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Rn"> 
        <div class="atomic fontGreen">
         86
        </div> 
        <div class="crystal fontGreen">
          fcc 
        </div> 
        <div class="symbol fontGreen">
          Rn 
        </div> 
        <div class="element-name fontGreen">
          Radon 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>10</sup>6s<sup>2</sup>6p<sup>6</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">10.7</span> 
        <span class="show-span boiling">-62</span> 
        <span class="show-span melting">-71</span> 
        <span class="show-span relative">222.0</span> 
        <span class="show-span radius">145</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第六行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Fr"> 
        <div class="atomic fontYellow">
         87
        </div> 
        <div class="crystal fontYellow">
          bcc 
        </div> 
        <div class="symbol fontYellow">
          Fr 
        </div> 
        <div class="element-name fontYellow">
          Francium 
        </div> 
        <span class="show-span oxidation">+1</span> 
        <span class="show-span electron">[Rn]7s<sup>1</sup></span> 
        <span class="show-span eleativity">0.9</span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling">677</span> 
        <span class="show-span melting">27</span> 
        <span class="show-span relative">223.0</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ra"> 
        <div class="atomic fontYellow">
         88
        </div> 
        <div class="crystal fontYellow hid"> 
        </div> 
        <div class="symbol fontYellow">
          Ra 
        </div> 
        <div class="element-name fontYellow">
          Radium 
        </div> 
        <span class="show-span oxidation">+2</span> 
        <span class="show-span electron">[Rn]7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">5.3</span> 
        <span class="show-span boiling">1140</span> 
        <span class="show-span melting">700</span> 
        <span class="show-span relative">226.0</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2 col-md-offset-2"> 
       <div class="elements" id="Rf"> 
        <div class="atomic ">
         104
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Rf 
        </div> 
        <div class="element-name ">
          Rutherfordium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>2</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">261.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Db"> 
        <div class="atomic ">
         105
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Db 
        </div> 
        <div class="element-name ">
          Dubnium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>3</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">262.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Sg"> 
        <div class="atomic ">
         106
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Sg 
        </div> 
        <div class="element-name ">
          Seaborgium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>4</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">263.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Bh"> 
        <div class="atomic ">
         107
        </div> 
        <div class="crystal hid"> 
        </div> 
        <div class="symbol ">
          Bh 
        </div> 
        <div class="element-name ">
          Bohrium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>5</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">264.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Hs"> 
        <div class="atomic ">
         108
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Hs 
        </div> 
        <div class="element-name ">
          Hassium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>6</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">265.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Mt"> 
        <div class="atomic ">
         109
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Mt 
        </div> 
        <div class="element-name ">
          Meitnerium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>7</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">277.0</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ds"> 
        <div class="atomic ">
         110
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Ds 
        </div> 
        <div class="element-name ">
          Darmstadtium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>8</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">283.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Rg"> 
        <div class="atomic ">
         111
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Rg 
        </div> 
        <div class="element-name ">
          Roentgenium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>9</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">282.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Cn"> 
        <div class="atomic ">
         112
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Cn 
        </div> 
        <div class="element-name ">
          Copernicium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">282.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Uut"> 
        <div class="atomic ">
         113
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Uut 
        </div> 
        <div class="element-name ">
          Nihonium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup>7p<sup>1</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">286.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Fl"> 
        <div class="atomic ">
         114
        </div> 
        <div class="crystal hid"> 
        </div> 
        <div class="symbol ">
          Fl 
        </div> 
        <div class="element-name ">
          Flerovium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup>7p<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">291.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Uup"> 
        <div class="atomic ">
         115
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Uup 
        </div> 
        <div class="element-name ">
          Ununpentium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup>7p<sup>3</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">290.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Lv"> 
        <div class="atomic ">
         116
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Lv 
        </div> 
        <div class="element-name ">
          Livermorium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup>7p<sup>4</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">295.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Uus"> 
        <div class="atomic ">
         117
        </div> 
        <div class="crystal  hid"> 
        </div> 
        <div class="symbol ">
          Uus 
        </div> 
        <div class="element-name ">
          Ununseptium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup>7p<sup>5</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">293.2</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Uuo"> 
        <div class="atomic fontGreen">
         118
        </div> 
        <div class="crystal fontGreen hid"> 
        </div> 
        <div class="symbol fontGreen">
          Uuo 
        </div> 
        <div class="element-name fontGreen">
          Ununoctium 
        </div> 
        <span class="show-span oxidation"></span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>10</sup>7s<sup>2</sup>7p<sup>6</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting"></span> 
        <span class="show-span relative">299.3</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第七行元素 --> 
    <div class="col-md-12" style="margin-top:25px;"></div> 
    <!-- 第八行 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2 col-md-offset-6"> 
       <div class="elements" id="La"> 
        <div class="atomic ">
         57
        </div> 
        <div class="crystal  hid">
          hcp 
        </div> 
        <div class="symbol ">
          La 
        </div> 
        <div class="element-name ">
          Lanthanum 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Xe]5d<sup>1</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.6</span> 
        <span class="show-span boiling">3455</span> 
        <span class="show-span melting">920</span> 
        <span class="show-span relative">138.9</span> 
        <span class="show-span radius">187</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ce"> 
        <div class="atomic ">
         58
        </div> 
        <div class="crystal ">
          fcc 
        </div> 
        <div class="symbol">
          Ce 
        </div> 
        <div class="element-name ">
          Cerium 
        </div> 
        <span class="show-span oxidation">+2,+3,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>2</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.5</span> 
        <span class="show-span boiling">3424</span> 
        <span class="show-span melting">799</span> 
        <span class="show-span relative">140.1</span> 
        <span class="show-span radius">182</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pr"> 
        <div class="atomic ">
         59
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol ">
          Pr 
        </div> 
        <div class="element-name ">
          Praseodymium 
        </div> 
        <span class="show-span oxidation">+3,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>3</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.5</span> 
        <span class="show-span boiling">3510</span> 
        <span class="show-span melting">931</span> 
        <span class="show-span relative">140.9</span> 
        <span class="show-span radius">182</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Nd"> 
        <div class="atomic ">
         60
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Nd 
        </div> 
        <div class="element-name ">
          Neodymium 
        </div> 
        <span class="show-span oxidation">+2,+3,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>4</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.5</span> 
        <span class="show-span boiling">3066</span> 
        <span class="show-span melting">1016</span> 
        <span class="show-span relative">144.2</span> 
        <span class="show-span radius">181</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pm"> 
        <div class="atomic ">
         61
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol ">
          Pm 
        </div> 
        <div class="element-name ">
          Promethium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Xe]4f<sup>5</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.6</span> 
        <span class="show-span boiling">3000</span> 
        <span class="show-span melting">1042</span> 
        <span class="show-span relative">144.9</span> 
        <span class="show-span radius">183</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Sm"> 
        <div class="atomic  ">
         62
        </div> 
        <div class="crystal ">
          trigonal 
        </div> 
        <div class="symbol  ">
          Sm 
        </div> 
        <div class="element-name  ">
          Samarium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Xe]4f<sup>6</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.6</span> 
        <span class="show-span boiling">1790</span> 
        <span class="show-span melting">1072</span> 
        <span class="show-span relative">150.4</span> 
        <span class="show-span radius">180</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Eu"> 
        <div class="atomic  ">
         63
        </div> 
        <div class="crystal">
          bcc 
        </div> 
        <div class="symbol  ">
          Eu 
        </div> 
        <div class="element-name  ">
          Europium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Xe]4f<sup>7</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.0</span> 
        <span class="show-span ionic">5.7</span> 
        <span class="show-span boiling">1596</span> 
        <span class="show-span melting">822</span> 
        <span class="show-span relative">152.0</span> 
        <span class="show-span radius">180</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Gd"> 
        <div class="atomic  ">
         64
        </div> 
        <div class="crystal ">
          hcp 
        </div> 
        <div class="symbol  ">
          Gd 
        </div> 
        <div class="element-name  ">
          Gadolinium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Xe]4f<sup>7</sup>5d<sup>1</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.2</span> 
        <span class="show-span boiling">3264</span> 
        <span class="show-span melting">1314</span> 
        <span class="show-span relative">157.3</span> 
        <span class="show-span radius">180</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Tb"> 
        <div class="atomic  ">
         65
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol ">
          Tb 
        </div> 
        <div class="element-name  ">
          Terbium 
        </div> 
        <span class="show-span oxidation">+3,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>9</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.9</span> 
        <span class="show-span boiling">3221</span> 
        <span class="show-span melting">1359</span> 
        <span class="show-span relative">158.9</span> 
        <span class="show-span radius">177</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Dy"> 
        <div class="atomic  ">
         66
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol  ">
          Dy 
        </div> 
        <div class="element-name  ">
          Dysprosium 
        </div> 
        <span class="show-span oxidation">+3,+4</span> 
        <span class="show-span electron">[Xe]4f<sup>10</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.9</span> 
        <span class="show-span boiling">2561</span> 
        <span class="show-span melting">1411</span> 
        <span class="show-span relative">162.5</span> 
        <span class="show-span radius">178</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Ho"> 
        <div class="atomic  ">
         67
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol  ">
          Ho 
        </div> 
        <div class="element-name  ">
          Holmium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Xe]4f<sup>11</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.0</span> 
        <span class="show-span boiling">2694</span> 
        <span class="show-span melting">1472</span> 
        <span class="show-span relative">164.9</span> 
        <span class="show-span radius">176</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Er"> 
        <div class="atomic  ">
         68
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol  ">
          Er 
        </div> 
        <div class="element-name  ">
          Erbium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Xe]4f<sup>12</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.1</span> 
        <span class="show-span boiling">2862</span> 
        <span class="show-span melting">1529</span> 
        <span class="show-span relative">167.3</span> 
        <span class="show-span radius">176</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Tm"> 
        <div class="atomic  ">
         69
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol  ">
          Tm 
        </div> 
        <div class="element-name  ">
          Thulium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Xe]4f<sup>13</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.2</span> 
        <span class="show-span boiling">1946</span> 
        <span class="show-span melting">1545</span> 
        <span class="show-span relative">168.9</span> 
        <span class="show-span radius">176</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Yb"> 
        <div class="atomic  ">
         70
        </div> 
        <div class="crystal">
          fcc 
        </div> 
        <div class="symbol  ">
          Yb 
        </div> 
        <div class="element-name  ">
          Ytterbium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.3</span> 
        <span class="show-span boiling">1194</span> 
        <span class="show-span melting">824</span> 
        <span class="show-span relative">173.0</span> 
        <span class="show-span radius">176</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Lu"> 
        <div class="atomic  ">
         71
        </div> 
        <div class="crystal">
          hcp 
        </div> 
        <div class="symbol  ">
          Lu 
        </div> 
        <div class="element-name  ">
          Lutetium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Xe]4f<sup>14</sup>5d<sup>1</sup>6s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">5.4</span> 
        <span class="show-span boiling">3393</span> 
        <span class="show-span melting">1663</span> 
        <span class="show-span relative">175.0</span> 
        <span class="show-span radius">174</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第九行元素 --> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2 col-md-offset-6"> 
       <div class="elements" id="Ac"> 
        <div class="atomic  ">
         89
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Ac 
        </div> 
        <div class="element-name  ">
          Actinium 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Rn]6d<sup>1</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">5.2</span> 
        <span class="show-span boiling">3198</span> 
        <span class="show-span melting">1051</span> 
        <span class="show-span relative">227.0</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Th"> 
        <div class="atomic  ">
         90
        </div> 
        <div class="crystal">
          fcc 
        </div> 
        <div class="symbol  ">
          Th 
        </div> 
        <div class="element-name  ">
          Thorium 
        </div> 
        <span class="show-span oxidation">+3,+4</span> 
        <span class="show-span electron">[Rn]6d<sup>2</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">6.1</span> 
        <span class="show-span boiling">4788</span> 
        <span class="show-span melting">1750</span> 
        <span class="show-span relative">232.0</span> 
        <span class="show-span radius">179</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pa"> 
        <div class="atomic  ">
         91
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Pa 
        </div> 
        <div class="element-name  ">
          Protactinium 
        </div> 
        <span class="show-span oxidation">+3,+4,+5</span> 
        <span class="show-span electron">[Rn]5f<sup>2</sup>6d<sup>1</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.1</span> 
        <span class="show-span ionic">5.9</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">1572</span> 
        <span class="show-span relative">231.0</span> 
        <span class="show-span radius">163</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="U"> 
        <div class="atomic  ">
         92
        </div> 
        <div class="crystal">
          cubic 
        </div> 
        <div class="symbol  ">
          U 
        </div> 
        <div class="element-name  ">
          Uranium 
        </div> 
        <span class="show-span oxidation">+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Rn]5f<sup>3</sup>6d<sup>1</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.2</span> 
        <span class="show-span boiling">4131</span> 
        <span class="show-span melting">1135</span> 
        <span class="show-span relative">238.0</span> 
        <span class="show-span radius">156</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Np"> 
        <div class="atomic  ">
         93
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Np 
        </div> 
        <div class="element-name  ">
          Neptunium 
        </div> 
        <span class="show-span oxidation">+3,+4,+5,+6,+7</span> 
        <span class="show-span electron">[Rn]5f<sup>4</sup>6d<sup>1</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.3</span> 
        <span class="show-span boiling">3902</span> 
        <span class="show-span melting">644</span> 
        <span class="show-span relative">237.0</span> 
        <span class="show-span radius">155</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Pu"> 
        <div class="atomic  ">
         94
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Pu 
        </div> 
        <div class="element-name  ">
          Plutonium 
        </div> 
        <span class="show-span oxidation">+3,+4,+5,+6,+7</span> 
        <span class="show-span electron">[Rn]5f<sup>6</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.1</span> 
        <span class="show-span boiling">3228</span> 
        <span class="show-span melting">640</span> 
        <span class="show-span relative">244.1</span> 
        <span class="show-span radius">159</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Am"> 
        <div class="atomic  ">
         95
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Am 
        </div> 
        <div class="element-name  ">
          Americium 
        </div> 
        <span class="show-span oxidation">+2,+3,+4,+5,+6</span> 
        <span class="show-span electron">[Rn]5f<sup>7</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.0</span> 
        <span class="show-span boiling">2011</span> 
        <span class="show-span melting">1176</span> 
        <span class="show-span relative">243.1</span> 
        <span class="show-span radius">173</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Cm"> 
        <div class="atomic  ">
         96
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Cm 
        </div> 
        <div class="element-name  ">
          Curium 
        </div> 
        <span class="show-span oxidation">+3,+4</span> 
        <span class="show-span electron">[Rn]5f<sup>8</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.0</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">1345</span> 
        <span class="show-span relative">247.1</span> 
        <span class="show-span radius">174</span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Bk"> 
        <div class="atomic  ">
         97
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Bk 
        </div> 
        <div class="element-name  ">
          Berkelium 
        </div> 
        <span class="show-span oxidation">+3,+4</span> 
        <span class="show-span electron">[Rn]5f<sup>9</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.2</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">1050</span> 
        <span class="show-span relative">247.1</span> 
        <span class="show-span radius">170</span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="col-md-4"> 
     <div class="row"> 
      <div class="col-md-2"> 
       <div class="elements" id="Cf"> 
        <div class="atomic  ">
         98
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Cf 
        </div> 
        <div class="element-name  ">
          Californium 
        </div> 
        <span class="show-span oxidation">+2,+3,+4</span> 
        <span class="show-span electron">[Rn]5f<sup>10</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.3</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">900</span> 
        <span class="show-span relative">251.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Es"> 
        <div class="atomic  ">
         99
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Es 
        </div> 
        <div class="element-name  ">
          Einsteinium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Rn]5f<sup>11</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.4</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">860</span> 
        <span class="show-span relative">252.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Fm"> 
        <div class="atomic  ">
         100
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Fm 
        </div> 
        <div class="element-name  ">
          Fermium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Rn]5f<sup>12</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.5</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">1527</span> 
        <span class="show-span relative">257.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Md"> 
        <div class="atomic  ">
         101
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Md 
        </div> 
        <div class="element-name  ">
          Mendelevium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Rn]5f<sup>13</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity">1.2</span> 
        <span class="show-span ionic">6.6</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">827</span> 
        <span class="show-span relative">258.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="No"> 
        <div class="atomic  ">
         102
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          No 
        </div> 
        <div class="element-name  ">
          Nobelium 
        </div> 
        <span class="show-span oxidation">+2,+3</span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic">6.7</span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">827</span> 
        <span class="show-span relative">259.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
      <div class="col-md-2"> 
       <div class="elements" id="Lr"> 
        <div class="atomic  ">
         103
        </div> 
        <div class="crystal   hid"> 
        </div> 
        <div class="symbol  ">
          Lr 
        </div> 
        <div class="element-name  ">
          Lawreclum 
        </div> 
        <span class="show-span oxidation">+3</span> 
        <span class="show-span electron">[Rn]5f<sup>14</sup>6d<sup>1</sup>7s<sup>2</sup></span> 
        <span class="show-span eleativity"></span> 
        <span class="show-span ionic"></span> 
        <span class="show-span boiling"></span> 
        <span class="show-span melting">1627</span> 
        <span class="show-span relative">262.1</span> 
        <span class="show-span radius"></span> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!-- 第十行元素 --> 
   </div> 
  </div>  
 </body>
</html>