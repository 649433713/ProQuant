<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2017/6/6
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="PO.recommendedStock.PeakPO"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="VO.marketPageVO.HotStockListVO" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>市场行情</title>
    <%@include file="common/head.jsp"%>
    <link href="../../css/myCSS/MarketPageCSS.css" rel="stylesheet">
    <link href="../../css/myCSS/MarketPageChartsCSS.css" rel="stylesheet">
    <script src="../../js/myJS/MarketJS.js" type="text/javascript"></script>
</head>
<body>
<!--导航栏start-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ProQuant</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="HomePage.jsp">首页</a></li>
            <li><a href="/MarketPage.do">大盘</a></li>
            <li><a href="/StockInfo.do">个股</a></li>
            <li><a href="/StockCompare.do">比较</a></li>
            <li><a href="#">策略</a></li>
            <li><a href="#">论坛</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li id="searchText"><input id="searchInput" type="text" placeholder="搜索"><i class="fa fa-search" aria-hidden="true"></i></li>
            <li><button id="loginButton"><i class="fa fa-user-circle" aria-hidden="true"></i>未登录</button></li>
            <li><img src="../images/skin.png"></li>
        </ul>
    </div>
</nav>
<!--导航栏end-->
<div class="m-container">
    <div class="m-box">
        <div class="m-head">
            <h2>市场行情</h2>
        </div>
        <div class="m-body">
            <div class="market-tab">
                <span class="cur">涨跌停</span>
                <span>昨日涨停今日收益</span>
                <input type="date" class="my-date-picker">
            </div>
            <div class=" hcharts clearfix">
                <div class="hcharts-left tab-hv-box">
                    <!--中间放置图的部分-->
                    <div class="hcharts-cont tab-hv-cont">
                        <div class="hcharts-legend"></div>
                        <div class="hcharts-main" id="zdfb"></div>
                    </div>
                </div>
                <div class="hcharts-right">
                    <h4>热门股票</h4>
                    <div>
                        <table>
                            <thead>
                            <tr>
                                <th style="width: 38px;">序号</th>
                                <th style="width: 70px;">股票ID</th>
                                <th style="width: 80px;">股票名称</th>
                                <th style="width: 80px;">今日涨幅</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!--标签里面的链接都没有设置*************************************************-->
                            <%--<%--%>
                                <%--HotStockListVO hotStockLists = (HotStockListVO)session.getAttribute("hotStocks");--%>
                                <%--ArrayList<PeakPO> peakPOArrayList = hotStockLists.getHotStocks();--%>
                                <%--int i = 0;--%>
                                <%--for(PeakPO peakPO:peakPOArrayList){--%>
                            <%--%>--%>
                            <% int i = 0;%>
                            <c:forEach var="peakPO" items="${hotStocks}">
                                <tr>
                                    <td class="num"><%=i%></td>
                                    <td>
                                        <a href="/StockInfo/toStockInfo/${peaoPO.stockId}" target="_self">${peakPO.stockId}</a>
                                    </td>
                                    <td>
                                        <a href="">${peakPO.stockName}</a>
                                    </td>
                                    <td>${peakPO.riseOrDown}</td>
                                </tr>
                                <% i++; %>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            <div class="mt30 clearfix">

                <div class="flash-single flash-small flash-sec1">
                    <div>
                        <strong class="m-off">沪深300</strong>
                        <span class="link-red"></span>
                        <span class="red"></span>
                        <span class="red"></span>
                    </div>
                    <!--*********************************************下面的div是用来存放echarts的*********************************************-->
                    <div class="price-box" id="hu" style="height: 180px;"></div>
                </div>
                <div class="flash-single flash-small flash-sec2">
                    <div>
                        <strong class="m-off">创业板</strong>
                        <span class="link-red"></span>
                        <span class="red"></span>
                        <span class="red"></span>
                    </div>
                    <!--*********************************************下面的div是用来存放echarts的*********************************************-->
                    <div class="price-box" id="chuang" style="height: 180px;"></div>
                </div>
                <div class="flash-single flash-small">
                    <div>
                        <strong class="m-off">中小板</strong>
                        <span class="link-red"></span>
                        <span class="red"></span>
                        <span class="red"></span>
                    </div>
                    <!--*********************************************下面的div是用来存放echarts的*********************************************-->
                    <div class="price-box" id="zhong" style="height: 180px;"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="m-box">
        <div class="m-head">
            <h2>个股行情</h2>
        </div>
        <div class="m-body m-pager-box">
            <div class="table-tab">
                <h4 class="cur">
                    <a href="javascript: void(0)" board="all">全部股票</a>
                </h4>
                <h4>
                    <a href="javascript: void(0)" board="all">沪深300</a>
                </h4>
                <h4>
                    <a href="javascript: void(0)" board="all">创业板</a>
                </h4>
                <h4>
                    <a href="javascript: void(0)" board="all">中小板</a>
                </h4>
            </div>
            <%--<div class="fixed_thead hide" style="display: none;">--%>
                <%--<table class="m-table m-pager-table">--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                        <%--<th style="width: 44px;">序号</th>--%>
                        <%--<th style="width: 68px;">代码</th>--%>
                        <%--<th style="width: 92px;">名称</th>--%>
                        <%--<th style="width: 68px;"><a href="javascript:void(0)" field="xj">现价<i></i></a></th>--%>
                        <%--<th style="width: 92px;" class="cur"><a href="javascript:void(0)" field="zdf" order="desc" class="desc">涨跌幅(%)<i></i></a></th>--%>
                        <%--<th style="width: 68px;"><a href="javascript:void(0)" field="zd">涨跌<i></i></a></th>--%>
                        <%--<th style="width: 92px;"><a href="javascript:void(0)" field="zs">涨速(%)<i></i></a></th>--%>
                        <%--<th style="width: 92px;"><a href="javascript:void(0)" field="hs">换手(%)<i></i></a></th>--%>
                        <%--<th style="width: 68px;"><a href="javascript:void(0)" field="lb">量比<i></i></a></th>--%>
                        <%--<th style="width: 68px;"><a href="javascript:void(0)" field="zf">振幅(%)<i></i></a></th>--%>
                        <%--<th style="width: 80px;"><a href="javascript:void(0)" field="cje">成交额<i></i></a></th>--%>
                        <%--<th style="width: 92px;"><a href="javascript:void(0)" field="ltg">流通股<i></i></a></th>--%>
                        <%--<th style="width: 92px;"><a href="javascript:void(0)" field="ltsz">流通市值<i></i></a></th>--%>
                        <%--<th style="width: 80px;"><a href="javascript:void(0)" field="syl">市盈率<i></i></a></th>--%>
                        <%--<!--th>概念题材</th-->--%>
                        <%--<th style="width: 44px;">加自选</th>--%>
                    <%--</tr>--%>
                    <%--</thead>--%>
                <%--</table>--%>
            <%--</div>--%>
            <div id="maincont" data-fixedthead="true">
                <table class="m-table m-pager-table">
                    <thead>
                    <tr>
                        <th style="width: 80px">序号</th>
                        <th style="width: 100px">股票ID</th>
                        <th style="width: 100px">股票名称</th>
                        <th style="width: 80px">现价</th>
                        <th style="width: 90px">开盘价</th>
                        <th style="width: 90px">昨日收盘价</th>
                        <th style="width: 90px">最高价</th>
                        <th style="width: 90px">最低价</th>
                        <th style="width: 80px">涨跌幅(%)</th>
                        <th style="width: 80px">成交量</th>
                        <th style="width: 80px">流通市值</th>
                        <th style="width: 80px">市盈率</th>
                        <th style="width: 80px">市净率</th>
                        <th style="width: 80px">加入自选</th>
                    </tr>
                    </thead>
                    <!--添加表格内容时，注意添加每个表格元素的标签不相同，有的是a，有的是td**********************************-->
                    <tbody>
                    <% int j = 0;%>
                    <c:forEach var="stock" items="${allStocks}">

                        <tr>
                            <td style="width: 80px"><%=j%></td>
                            <td style="width: 100px">
                                <a href="#">${stock.value.code}</a>
                            </td>
                            <td style="width: 100px">
                                <a href="#">${stock.value.name}</a></td>
                            <td style="width: 80px">${stock.value.trade}</td>
                            <td style="width: 90px">${stock.value.open}</td>
                            <td style="width: 90px">${stock.value.settlement}</td>
                            <td style="width: 90px">${stock.value.high}</td>
                            <td style="width: 90px">${stock.value.low}</td>
                            <td style="width: 80px">${stock.value.changepercent}</td>
                            <%--<td>${stock.value.}</td>--%>
                            <td style="width: 80px">${stock.value.volume}</td>
                            <td style="width: 80px">${stock.value.nmc}</td>
                            <td style="width: 80px">${stock.value.per}</td>
                            <td style="width: 80px">${stock.value.pb}</td>
                            <td style="width: 80px">
                                <a href="javascript:void(0);" title="加入自选" class="j_addstock">
                                    <img src="../images/addstock.png">
                                </a>
                            </td>
                        </tr>
                        <% j++; %>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="m-pager m-page">
                    <!--1.a标签需要实时地更换，最一开始是没有首页和上一页的，但是一旦不处于首页，就要出现这两个标签，
                        2.合适出现6、7、8、9-->
                    <a href="javascript:void(0);" class="changePage cur">1</a>
                    <a href="javascript:void(0);" class="changePage">2</a>
                    <a href="javascript:void(0);" class="changePage">3</a>
                    <a href="javascript:void(0);" class="changePage">4</a>
                    <a href="javascript:void(0);" class="changePage">5</a>
                    <a href="javascript:void(0);" class="changePage">下一页</a>
                    <a href="javascript:void(0);" class="changePage">尾页</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!--页脚start-->
<div class="footer  container">
    <div class="row">
        <div class="left-footer col-sm-9">
            <div>
                <h2>关于ProQuant</h2>
                <br>
                <p>ProQuant是一款基于提供股票市场情况展示，个股信息展示，股票各项指标预测功能于一体的多功能股票查询、
                    <br>分析的软件。</p>
            </div>
        </div>
        <div class="right-footer col-sm-3">
            <div>
                <h2>关于我们</h2>
                <br>
                <p></p>
            </div>
            <div>
                <a href=""><img src="../images/weibo.png" alt="微博"></a>
                <a href=""><img src="../images/weixin.png" alt="微信"></a>
                <a href=""><img src="../images/qq.png" alt="QQ"></a>

            </div>
        </div>
    </div>
</div>
<!--页脚end-->
<script type="text/javascript" src="../../charts/areaChart.js"></script>
<script type="text/javascript" src="../../charts/marketAreaChart.js"></script>
</body>
</html>
