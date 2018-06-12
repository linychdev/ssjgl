function getRefFileDivHtml(refId, doi, existsFileHtml){
    var refId = refId ? refId : "";
    var doi = doi ? doi : "";
    var existsFileHtml = existsFileHtml ? existsFileHtml: "";
    var html = "<div class = 'refFileUpDiv' id='"+refId+"'>" +
                 "<form class='form-horizontal' enctype='multipart/form-data' method='post'>"+
                  "<div class='form-group'>"+
                    "<label class='col-xs-2 control-label'>文献DOI:</label>"+
                    "<div class='col-xs-10' id=''>"+
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
                        "<input type='file' id='' name='potenFile' />"+
                    "</div>"+
                    "<div class = 'col-xs-1' style = 'margin-top:10px;'>"+
                        "<span ><a href='javascript:void(0);' class = 'uploadFileBtn'><i class='fa fa-upload fa-fw'></i></a></span>"+
                    "</div>"+
                    "</div>"+
                   "</form>" +
                 "</div>";
    return html;
}

function getRefSildUpHtml(refId, refContent, selectedValue){
    var refId = refId ? refId : "";
    var refContent = refContent ? refContent : "";
    var selectedValue = selectedValue ? selectedValue : 0;
    
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
                if(selectedValue == 1){
                    slideUpHtml += 
                    "<option value='1' selected>势库</option>"+
                    "<option value='2'>其他</option>";
                }else if(selectedValue == 2){
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
            "<input type='text' class='form-control' name='referenceDoi' placeholder='reference DOI'>"+
            "</div>"+
            "</div>"+
            "<div class='form-group'>"+
            "<label for='' class='col-sm-3 control-label'>说明:</label>"+
            "<div class='col-sm-8'>"+
            "<textarea type='text' rows='2' cols='20' class='form-control' name='referenceDesc' placeholder='reference desc'></textarea>"+
            "</div>"+
            "</div>"+
            "</div>"+
        "</li>";
 
     return slideUpHtml;
}

function getPotenEditHtml(funOptionHtml, elementOptionHtml){
    
var funOptionHtml = funOptionHtml ? funOptionHtml : "";
var elementOptionHtml = elementOptionHtml ? elementOptionHtml : "";
    
var potenEditHtml = 
            "<form class='form-horizontal'>"+
                "<div class='form-group'>"+
                "<label for='' class='col-sm-3 control-label'>选择分组:</label>"+
                "<div class='col-sm-8'>"+
                    "<select class='form-control potenSelectGroup'>"+
                    "<option value='44192139591811e8a71b1c1b0da988f8' selected>Metal Alloys</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f1'>Semiconductors</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f2'>Ionic Crystals</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f3'>Interface</option>"+
                    "<option value='44192139591811e8a71b1c1b0da988f4'>Others</option>"+
                    "<option value='6'>aa</option>"+
                    "<option value='7'>bb</option>"+
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
                    "<input type='text' class='form-control' id='potenName' placeholder='Potentials name'>"+
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
                          "<input type='text' class='form-control' id='potenDesc' placeholder='Potentials desc'>"+
                      "</div>"+
                  "</div>"+
                "<div class='form-group'>"+
                  "<label for='' class='col-sm-3 control-label'>备注:</label>"+
                  "<div class='col-sm-8'>"+
                      "<textarea type='text' rows='4' cols='20' class='form-control' id='potenNote' placeholder='Potentials note'></textarea>"+
                  "</div>"+
                "</div>"+
                "<div class='form-group' style = 'padding-top: 50px;'>"+
                     "<div class='col-sm-4 col-sm-offset-4'>"+
                        "<div class='btn-success form-control' style = 'text-align: center;' id='savePotenBtn'>保存</div>"+
                     "</div>"+
                "</div>"+     
               "</form>";
    return potenEditHtml;
}


function getRefEditHtml(slideUpHtml){
    var slideUpHtml = slideUpHtml ? slideUpHtml : "";
    var refEditHtml = "<form class='form-horizontal'>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
                        "<div class='col-sm-8' id = 'ref-edit-poten-name'>"+
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