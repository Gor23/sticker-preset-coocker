<head>
    <meta charset="utf-8"/>
    <title>Изменение цвета текста</title>
    <style>
        .redtext {
            color: red; /* Красный цвет выделения */
        }
    </style>
    <style>
        .greentext {
            color: green; /* Красный цвет выделения */
        }
    </style>
</head>

<#if defaultPreset??>
<span class = "redtext"> Ошибка при сохранениии файла</span>
<#else>
<span class = "greentext"> Файл успешно сохранён</span>
</#if>

<form action="input" method="GET">
    <div class="form-group">
        <button class="btn btn-default" type="submit">Назад</button>
    </div>
</form>

