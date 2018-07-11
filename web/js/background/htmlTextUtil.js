function getElementOptionHtml(elementList){
    var elementOptionHtml = "";
    for(var i=0;i<elementList.length;i++){  
        var option = "<option value = '"+ elementList[i].id +"'>"+elementList[i].name+"</option>";
        elementOptionHtml += option;
    }
    return elementOptionHtml;
}

function getFunOptionHtml(functionList){
    var funOptionHtml = "";
    for(var i=0;i<functionList.length;i++){  
        var option = "<option>"+functionList[i].name+"</option>";
        funOptionHtml += option;
    }
    return funOptionHtml;
}


function getSlideUpHtml(refList){
    var slideUpHtml ="";
    if(refList && refList.length > 0){
        for(var i=0;i<refList.length;i++){
            var refBean = refList[i];
            var reference = refBean.reference;
            slideUpHtml += getRefSildUpHtml(reference);
        }
    }else{
        slideUpHtml = getRefSildUpHtml();
    }
    return slideUpHtml;
}

function getEditorPotenPageHtml(potenCombId){
    $.ajaxSettings.async = false;
    var html = "";
    var elementOptionHtml = "";
    var funOptionHtml = "";
    var slideUpHtml = "";
    var potenEditHtml = "";
    var refEditHtml = "";
    var fileEditHtml = "";
    $.post(contextPath + "/background/elementList", {}, function(data) {
        elementOptionHtml = getElementOptionHtml(data.elementList);
        funOptionHtml =getFunOptionHtml(data.functionList);
    }, "json");
    if(potenCombId){
        $.post(contextPath + "/manage/selectComb", {combId:potenCombId}, function(data) {
            var combDetail = data.combDetail;
            slideUpHtml = getSlideUpHtml(combDetail.referenceInfos);
            refEditHtml = getRefEditHtml(combDetail.elementComb.cCombName, slideUpHtml);
            
            for(var i=0;i<combDetail.referenceInfos.length;i++){
                var refInfo = combDetail.referenceInfos[i];
                var refFiles = refInfo.potentialsFiles;
                var existsFileHtml = "";
                for(var j=0;j<refFiles.length;j++){
                    var refFile = refFiles[j];
                    existsFileHtml += getExistsFileHtml(refFile.cId, refFile.cFileName, refFile.nFileType);
                }
                fileEditHtml += getRefFileDivHtml(refInfo.reference.cId, refInfo.reference.cDoi, existsFileHtml);
            }
            
            potenEditHtml = getPotenEditHtml(combDetail, funOptionHtml, elementOptionHtml);
            
        }, "json");
    }else{
        slideUpHtml = getSlideUpHtml();
        refEditHtml = getRefEditHtml("",slideUpHtml);
        potenEditHtml = getPotenEditHtml(null, funOptionHtml, elementOptionHtml);
    }
    
    html += "<div class='layui-tab layui-tab-brief' lay-filter='docDemoTabBrief'>"+
                  "<ul class='layui-tab-title'>"+
                  "<li class='layui-this'>编辑原子间势</li>"+
                  "<li>编辑相关文献</li>"+
                  "<li>编辑势数据文件</li>"+
                "</ul>"+
                "<div class='layui-tab-content' style='height: 90%; overflow-y:auto; overflow-x:hidden;'>"+
                  
                  "<div class='layui-tab-item layui-show edit-poten-tab'>"+
                      potenEditHtml+
                  "</div>"+
                  
                  "<div class='layui-tab-item edit-ref-tab'>"+
                      refEditHtml +
                  "</div>"+
                  
                  "<div class='layui-tab-item upload-file-tab'>"+
                      fileEditHtml +
                  "</div>"+
                  
                "</div>"+
            "</div>";
    
    
    $.ajaxSettings.async = true;
    return html;
}

function getRefFileDivHtml(refId, doi, existsFileHtml){
    var refId = refId ? refId : "";
    var doi = doi ? doi : "";
    var existsFileHtml = existsFileHtml ? existsFileHtml: "";
    var html = "<div class = 'refFileUpDiv' id='"+refId+"'>" +
                 "<form class='form-horizontal' enctype='multipart/form-data' method='post'>"+
                  "<div class='form-group'>"+
                    "<label class='col-xs-2 control-label'>文献DOI:</label>"+
                    "<div class='col-xs-10' id='' style = 'padding-top: 9px;'>"+
                        doi +
                    "</div>"+
                  "</div>"+
                  "<div class = 'form-group'>"+
                    "<div class='col-xs-12 existsFileBox'>"+
                        existsFileHtml +
                    "</div>"+
                  "</div>"+
                  "<div class = 'form-group'>"+
                    "<label for='' class='col-xs-2 control-label'>文件类型:</label>"+
                    "<div class='col-xs-3'>"+
                       "<select class='form-control selectFileType'>"+
                        "<option value = '1' selected>参数文件</option>"+
                        "<option value = '2'>离散文件</option>"+
                       "</select>"+
                    "</div>"+
                    "<div class='col-xs-3' style = 'margin-top:7px;'>"+
                        "<input type='file' name='potenFile' />"+
                    "</div>"+
                    "<div class = 'col-xs-1' style = 'margin-top:10px;'>"+
                        "<span ><a href='javascript:void(0);' class = 'uploadFileBtn'><i class='fa fa-upload fa-fw'></i></a></span>"+
                    "</div>"+
                    "</div>"+
                   "</form>" +
                 "</div>";
    return html;
}

function getRefSildUpHtml(reference){
    var refId = "";
    var refContent = "";
    var refNote = "";
    var doi = "";
    var refSource = 0;
    if(reference){
        refId = reference.cId ? reference.cId : "";
        refContent = reference.cContent ? reference.cContent : "";
        refNote = reference.cNote ? reference.cNote : "";
        doi = reference.cDoi ? reference.cDoi : "";
        refSource = reference.nSource ? reference.nSource : 0;
    }
    
    var slideUpHtml = 
        "<li id = '"+refId+"'>" +
            "<span class = 'glyphicon glyphicon-menu-down fold-ref-div'></span>"+
            "<div class = 'glyphicon glyphicon-remove remove-ref-div'></div>"+
            "<div class='hid'>"+
                "<div class='form-group'>"+
                "<label for='' class='col-sm-3 control-label'>相关文献:</label>"+
                "<div class='col-sm-8'>"+
                    "<textarea type='text' rows='3' cols='20' class='form-control' name='referenceText' placeholder='reference text'>" +
                        refContent +
                    "</textarea>"+
                "</div>"+
              "</div>"+
            "<div class='form-group'>"+
            "<label for='' class='col-sm-3 control-label'>文献来源:</label>"+
            "<div class='col-sm-8'>"+
                "<select class='form-control selectSource'>";
                if(refSource == 1){
                    slideUpHtml += 
                    "<option value='1' selected>势库</option>"+
                    "<option value='2'>其他</option>";
                }else if(refSource == 2){
                    slideUpHtml += 
                        "<option value='1'>势库</option>"+
                        "<option value='2' selected>其他</option>";
                }else{
                    slideUpHtml += 
                        "<option value='1' selected>势库</option>"+
                        "<option value='2'>其他</option>";
                }
 slideUpHtml += "</select>"+
            "</div>"+
            "</div>"+
            "<div class='form-group'>"+
            "<label for='' class='col-sm-3 control-label'>DOI:</label>"+
            "<div class='col-sm-8'>"+
            "<input type='text' class='form-control' name='referenceDoi' placeholder='reference DOI' value='"+doi+"'>"+
            "</div>"+
            "</div>"+
            "<div class='form-group'>"+
            "<label for='' class='col-sm-3 control-label'>说明:</label>"+
            "<div class='col-sm-8'>"+
            "<textarea type='text' rows='2' cols='20' class='form-control' name='referenceDesc' placeholder='reference desc'>" +
                refNote+
            "</textarea>"+
            "</div>"+
            "</div>"+
            "</div>"+
        "</li>";
 
     return slideUpHtml;
}

function getPotenEditHtml(combDetail, funOptionHtml, elementOptionHtml){
    
    var potenName = "";
    var potenId = "";
    var potenNote = "";
    var potenDesc = "";
    var scopeId = "";
    var functions = new Array();
    var elements = new Array();
    if(combDetail){
        var elementComb = combDetail.elementComb;
        functions = combDetail.functions;
        elements = combDetail.elements;
        potenName = elementComb.cCombName ? elementComb.cCombName : "";
        potenId = elementComb.cId ? elementComb.cId : "";
        potenNote = elementComb.cNote ? elementComb.cNote : "";
        potenDesc = elementComb.cDescription ? elementComb.cDescription : "";
        scopeId = elementComb.cScopeId ? elementComb.cScopeId : "";
    }
    var funOptionHtml = funOptionHtml ? funOptionHtml : "";
    var elementOptionHtml = elementOptionHtml ? elementOptionHtml : "";
        
    var potenEditHtml = 
            "<form class='form-horizontal' id='"+potenId+"'>"+
                "<div class='form-group'>"+
                "<label for='' class='col-sm-3 control-label'>选择分组:</label>"+
                "<div class='col-sm-8'>"+
                    "<select class='form-control potenSelectGroup'>"+
                    "<option value='44192139591811e8a71b1c1b0da988f8' selected>Metal Alloys</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f1'>Semiconductors</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f2'>Ionic Crystals</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f3'>Interface</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f4'>Others</option>"+
                    "</select>"+
                "</div>"+
                "</div>"+
                "<div class='form-group'>"+
                    "<label for='tokens' class='col-sm-3 control-label'>选择函数:</label>"+
                    "<div class = 'col-sm-8 functionArray'>"+
                        "<select id='id_select_fun' class='selectpicker ' multiple data-live-search='true'>"+
                           funOptionHtml+
                        "</select>"+
                    "</div>"+
                "</div>"+
                  "<div class='form-group'>"+
                  "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
                  "<div class='col-sm-8'>"+
                    "<input type='text' class='form-control' id='potenName' placeholder='Potentials name' value='"+potenName+"'>"+
                  "</div>"+
                  "</div>"+
                  "<div class='form-group'>"+
                      "<label for='tokens' class='col-sm-3 control-label'>选择元素:</label>"+
                      "<div class = 'col-sm-8 elementsArray'>"+
                          "<select id='id_select' class='selectpicker ' multiple data-live-search='true'>"+
                             elementOptionHtml+
                          "</select>"+
                      "</div>"+
                  "</div>"+
                  "<div class='form-group'>"+
                      "<label for='' class='col-sm-3 control-label'>说明:</label>"+
                      "<div class='col-sm-8'>"+
                          "<input type='text' class='form-control' id='potenDesc' placeholder='Potentials desc' value='"+potenDesc+"'>"+
                      "</div>"+
                  "</div>"+
                "<div class='form-group'>"+
                  "<label for='' class='col-sm-3 control-label'>备注:</label>"+
                  "<div class='col-sm-8'>"+
                      "<textarea type='text' rows='4' cols='20' class='form-control' id='potenNote' placeholder='Potentials note'>" +
                          potenNote+
                      "</textarea>"+
                  "</div>"+
                "</div>"+
                "<div class='form-group' style = 'padding-top: 50px;'>"+
                     "<div class='col-sm-4 col-sm-offset-4'>"+
                        "<div class='btn-success form-control' style = 'text-align: center;' id='savePotenBtn'>保存</div>"+
                     "</div>"+
                "</div>"+     
               "</form>";
                
               _html = $(potenEditHtml);
               _html.find(".potenSelectGroup option").each(function(){
                    if($(this).val() == scopeId){
                        $(this)[0].selected = true;
                        $(this).siblings()[0].selected = false;
                    }
                });
                
                _html.find(".functionArray .selectpicker option").each(function(){
                    for(var i=0;i<functions.length;i++){
                        var fun = functions[i];
                        if($(this).text() == fun.cName){
                            $(this).attr("selected",true);
                        }
                    }
                });
                
                
                _html.find(".elementsArray .selectpicker option").each(function(){
                    for(var i=0;i<elements.length;i++){
                        var elem = elements[i];
                        if($(this).text() == elem.cSymbol){
                            $(this).attr("selected",true);
                        }
                    }
                });
    return potenEditHtml;
}


function getRefEditHtml(combName, slideUpHtml){
    var combName = combName ? combName : "";
    var slideUpHtml = slideUpHtml ? slideUpHtml : "";
    var refEditHtml = "<form class='form-horizontal'>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
                        "<div class='col-sm-8' id = 'ref-edit-poten-name'>"+
                            combName+
                        "</div>"+
                        "</div>"+
                        "<ul id='myul'>"+
                        "<div class = 'slideUp'>" +
                            slideUpHtml +
                        "</div>"+
                          "<div class='form-group' style = 'padding-top: 20px;'>"+
                               "<div class='col-sm-2 col-sm-offset-3'>"+
                                  "<div class='btn-success form-control' style = 'text-align: center;' id='addRefDivBtn'>继续添加</div>"+
                               "</div>"+
                               "<div class='col-sm-2 col-sm-offset-2'>"+
                               "<div class='btn-success form-control' style = 'text-align: center;' id='saveRefBtn'>保存全部</div>"+
                               "</div>"+
                          "</div>"+
                        "</form>";
    return refEditHtml;
}

function getExistsFileHtml(fileId, fileName,fileType){
    var fileId = fileId ? fileId : "";
    var fileName = fileName ? fileName : "";
    var fileType = fileType ? fileType : 1;
    
    var existsFileHtml = "<div class='col-xs-12 existsDiv' id = '"+fileId+"'>" +
                            "<label for='' class='col-xs-2 control-label'>文件类型:</label>"+
                            "<div class='col-xs-3'>";
                            if(fileType == 1){
                                existsFileHtml += "参数文件";
                            }else{
                                existsFileHtml += "数据文件";
                            }
       existsFileHtml += "</div>"+
                            "<div class='col-xs-3' style = 'margin-top:7px;'>"+
                             "<span ><a href='javascript:void(0);' class = 'glyphicon glyphicon-file'>"+fileName+"</a></span>"+
                            "</div>"+
                            "<div class = 'col-xs-1' style = 'margin-top:10px;'>"+
                                "<span ><a href='javascript:void(0);' class = 'deleteFileBtn'><i class='glyphicon glyphicon-remove'></i></a></span>"+
                            "</div>" +
                           "</div>";
    
    return existsFileHtml;
}