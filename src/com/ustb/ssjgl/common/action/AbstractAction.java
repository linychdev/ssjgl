package com.ustb.ssjgl.common.action;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
/**
 * 控制器基类
 * 
 * @author linych
 * @version 1.0
 */
public class AbstractAction {
    /**
     * 自定义分页页面DIY
     * @param response HttpServletResponse
     * @param data 分页数据
     */
//    protected void writeAjaxList(HttpServletResponse response, PagableData data) {
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        QueryInfo queryInfo = data.getPageInfo();
//        dataMap.put("records", data.getTotal());// 总记录数
//        dataMap.put("page", queryInfo.getPage()); // 当前页
//        // 计算总页数
//        if (queryInfo.getRows() > 0) {
//            int lastpage = data.getTotal() / queryInfo.getRows();
//            if (data.getTotal() % queryInfo.getRows() > 0) {
//                lastpage++;
//            }
//            dataMap.put("total", lastpage);
//        }
//        dataMap.put("rows", data.getDataList()); // 记录数据集合
//        this.writeAjaxObject(response, dataMap);
//    }

    /**
     * 写回ajax列表数据(内存分页)
     * @param response HttpServletResponse
     * @param data 分页数据
     */
//    protected void writeDataTableList(HttpServletResponse response, PagableData data) {
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        DatatableQueryInfo queryInfo = (DatatableQueryInfo) data.getPageInfo();
//        dataMap.put("iTotalRecords", data.getDataList().size());// 总记录数
//        dataMap.put("iTotalDisplayRecords", data.getTotal()); // 当前页
//        dataMap.put("sEcho", queryInfo.getsEcho());
//        dataMap.put("aaData", data.getDataList()); // 记录数据集合
//        this.writeAjaxObject(response, dataMap);
//    }

    /**
     * 写回ajax数据
     * @param response HttpServletResponse
     * @param data 字符串内容
     */
    protected void writeAjaxString(HttpServletResponse response, String data) {
        if (data == null) {
            return;
        }
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写回ajax数据
     * @param response HttpServletResponse
     * @param data list或map对象
     */
    protected void writeAjaxObject(HttpServletResponse response, Object data) {
        if (data == null) {
            return;
        }
        String str = null;
        if ((data instanceof Collection<?>) || (data.getClass().isArray())) {
            str = JSONArray.fromObject(data).toString();
        } else {
            str = JSONObject.fromObject(data).toString();
        }
        this.writeAjaxString(response, str);
    }

    /**
     * 返回错误信息
     * @param response HttpServletResponse
     * @param message 信息
     */
    protected void sendAjaxError(HttpServletResponse response, String message) {
        JSONObject data = new JSONObject();
        data.put("success", false);
        data.put("message", message);
        this.writeAjaxString(response, data.toString());
    }

    /**
     * @param response HttpServletResponse
     * @param message 信息
     */
    protected void sendAjaxError2(HttpServletResponse response, String message) {
        JSONObject data = new JSONObject();
        data.put("success", false);
        data.put("messages", message);
        this.writeAjaxString(response, data.toString());
    }

    /**
     * 返回错误信息
     * @param response HttpServletResponse
     * @param item String
     * @param msg String
     */
    protected void sendAjaxError(HttpServletResponse response, String item, String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", Boolean.FALSE);
        if (StringUtils.isNotBlank(item)) {
            result.put("item", item);
        }
        result.put("messages", msg);
        this.writeAjaxObject(response, result);
    }

    /**
     * 返回成功信息
     * @param response HttpServletResponse
     * @param msg String
     */
    protected void sendAjaxSuccess(HttpServletResponse response, String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", Boolean.TRUE);
        if (StringUtils.isNotBlank(msg)) {
            result.put("messages", msg);
        }
        this.writeAjaxObject(response, result);
    }

    /**
     * @param request HttpServletRequest
     * @return
     */
//    protected QueryInfo getDatatableQueryInfo(HttpServletRequest request) {
//        DatatableParam param = new DatatableParam();
//        populateProperty(request, param);
//        DatatableQueryInfo queryInfo = new DatatableQueryInfo();
//        queryInfo.setsEcho(param.getSEcho());
//        if (param.getIDisplayLength() > 0) {
//            queryInfo.setPage(param.getIDisplayStart() / param.getIDisplayLength() + 1);
//        }
//        queryInfo.setRows(param.getIDisplayLength());
//
//        String[] displayCol = new String[param.getIColumns()];
//        for (int i = 0; i < param.getIColumns(); i++) {
//            displayCol[i] = request.getParameter("mDataProp_" + i);
//        }
//
//        for (int i = 0; i < param.getISortingCols(); i++) {
//            String sColIndex = request.getParameter("iSortCol_" + i);
//            String sCol = displayCol[Integer.parseInt(sColIndex)];
//            String sOrd = request.getParameter("sSortDir_" + i);
//            SortInfo sortInfo = new SortInfo(sCol, sOrd);
//            queryInfo.getSortList().add(sortInfo);
//        }
//        String page = request.getParameter("page");
//        String rows = request.getParameter("rows");
//        if (StringUtils.isNotBlank(page)) {
//            queryInfo.setPage(Integer.valueOf(page));
//        }
//        if (StringUtils.isNotBlank(rows)) {
//            queryInfo.setRows(Integer.valueOf(rows));
//        }
//        return queryInfo;
//    }

    /**
     * DatatableParam
     * @author wangjianchao
     * @version 1.0
     *
     */
    static class DatatableParam {
        private String sEcho;

        private String sSearch;

        private int iDisplayLength;

        private int iDisplayStart;

        private int iColumns;

        private int iSortingCols;

        private String sColumns;

        public String getSEcho() {
            return sEcho;
        }

        public void setSEcho(String sEcho) {
            this.sEcho = sEcho;
        }

        public String getSSearch() {
            return sSearch;
        }

        public void setSSearch(String sSearch) {
            this.sSearch = sSearch;
        }

        public int getIDisplayLength() {
            return iDisplayLength;
        }

        public void setIDisplayLength(int iDisplayLength) {
            this.iDisplayLength = iDisplayLength;
        }

        public int getIDisplayStart() {
            return iDisplayStart;
        }

        public void setIDisplayStart(int iDisplayStart) {
            this.iDisplayStart = iDisplayStart;
        }

        public int getIColumns() {
            return iColumns;
        }

        public void setIColumns(int iColumns) {
            this.iColumns = iColumns;
        }

        public int getISortingCols() {
            return iSortingCols;
        }

        public void setISortingCols(int iSortingCols) {
            this.iSortingCols = iSortingCols;
        }

        public String getSColumns() {
            return sColumns;
        }

        public void setSColumns(String sColumns) {
            this.sColumns = sColumns;
        }
    }

    /**
     * 从request中提取属性到pojo中
     * 
     * @param request HttpServletRequest
     * @param pojo Object
     */
    protected void populateProperty(HttpServletRequest request, Object pojo) {
        ServletRequestDataBinder dataBinder = new ServletRequestDataBinder(pojo);
        dataBinder.bind(request);
    }

    /**
     * 写回空ajax列表
     * @param response HttpServletResponse
     * @param qi QueryInfo
     */
//    protected void writeNullDataTableList(HttpServletResponse response, QueryInfo qi) {
//        PagableData pagableData = new PagableData();
//        pagableData.setDataList(new ArrayList<Object>());
//        pagableData.setPageInfo(qi);
//        pagableData.setTotal(0);
//        this.writeDataTableList(response, pagableData);
//    }
}
