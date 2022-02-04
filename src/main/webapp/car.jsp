<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CARS</title>
</head>
<body>

<h1>List of cars</h1>
${cars}

<br/>

<h2>To add new car press "Add car" button</h2>
<form method="POST" action="/Spring_4_practice_war_exploded/car/add">
    <table>
        <tr>
            <td><label for="mark">Mark</label></td>
            <td><input type="text" name="mark" id="mark"/></td>
        </tr>
        <tr>
            <td><label for="model">Model</label></td>
            <td><input type="text" name="model" id="model"/></td>
        </tr>
        <tr>
            <td><label for="engine">Engine</label></td>
            <td><input type="number" name="engine" id="engine"/></td>
        </tr>
        <tr>
            <td><label for="price">Price</label></td>
            <td><input type="nuber" name="price" id="price"/></td>
        </tr>
        <tr>
            <td><label for="speed">Speed</label></td>
            <td><input type="number" name="speed" id="speed"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add Car">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="POST" action="/Spring_4_practice_war_exploded/car/findByMark">
    <table>
        <tr>
            <td><label for="mark">Mark</label></td>
            <td><input type="text" name="mark"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search by mark">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="POST" action="/Spring_4_practice_war_exploded/car/findByMarkAndModelAndSpeed">
    <table>
        <tr>
            <td><label for="mark">Mark</label></td>
            <td><input type="text" name="mark"/></td>
        </tr>
        <tr>
            <td><label for="model">Model</label></td>
            <td><input type="text" name="model"/></td>
        </tr>
        <tr>
            <td><label for="speed">Speed</label></td>
            <td><input type="number" name="speed"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search by mark, model and speed">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="GET" action="/Spring_4_practice_war_exploded/car/remove">
    <table>
        <tr>
            <td><label for="mark">Mark</label></td>
            <td><input type="text" name="mark"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Delete by mark">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
