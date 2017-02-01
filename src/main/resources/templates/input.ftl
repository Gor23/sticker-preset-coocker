<html>
<#include 'head.ftl'>
<body>
<#include 'menu.ftl'>
<div class="row">
    <div class="col-sm-2 content text-left">
        <form action="preset-table" method="GET">
            <div>
                <h3 class="text-info">Введите ID</h3>
                <input type="number" name="ID" class="form-control">
            </div>
            <div class="form-group">
                <button class="btn btn-default" type="submit">Далее</button>
            </div>
        </form>
    </div>
<#if fail??>
    <#if fail == true>
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title text-danger">Ошибка сохранения файла</h4>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title text-success">Файл успешно сохранён</h4>
                    </div>
                </div>
            </div>
        </div>
    </#if>
</#if>
</div>
</body>
</html>

