<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TABLE_99</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	
		<style>
        .tableBorder {
		    width: 100%;
		    text-align: center;
		    font-size: larger;
		}
        .tableBorder td {
        	padding: 10px 0px;
            font-family: 'Courier New', monospace;
            text-align: center;
        }
        .red-bg {
            background-color: rgba(255, 0, 0, 0.1);
        }
        .yellow-bg {
            background-color: rgba(255, 255, 0, 0.1);
        }


    </style>
	
	
	</head>
	<body>
		<h1>千千萬萬乘法表</h1>
		<hr />
		<form action="table9x9" method="post">
			初始數字 : <input type="number" name="start" 
			value="${start != null ? start : 2}" required />
			幾行 :  
			<input type="number" name="rows" value="${rows != null ? rows : 2}" required />
			幾列 :
			<input type="number" name="cols" value="${cols != null ? cols : 4}" required />
			<input type="submit" value="change"/>
		</form>
		
		<hr />
		
		<table id="tableColor" class="tableBorder" >
		
			<%
		
			int ROWS = (request.getAttribute("rows") != null) ? (Integer)request.getAttribute("rows") : 2;
			int COLS = (request.getAttribute("cols") != null) ? (Integer)request.getAttribute("cols") : 4;
			int START = (request.getAttribute("start") != null) ? (Integer)request.getAttribute("start") : 2;
		
			  for (int k = 0; k < ROWS; k++) {
			        out.println("<tr>");
			        for (int j = 0; j < COLS; j++) {
			            out.println("<td>");
			            int newj = START + k * COLS + j;
			            for (int i = 1; i <= 9; i++) {
			                out.println(String.format("%2d X %2d = %3d<br/>", newj, i, newj * i));
			            }
			            out.println("</td>");
			        }
			        out.println("</tr>");
			}
			%>	
			
			
		</table>

		
		<script>
			document.addEventListener('DOMContentLoaded', function() {
			    const table = document.getElementById('tableColor');
			    const rows = table.querySelectorAll('tr');
			    const totalColumns = rows[0].querySelectorAll('td').length;
			
			    rows.forEach((row, rowIndex) => {
			        const cells = row.querySelectorAll('td');
			        	cells.forEach((cell, cellIndex) => {
			            if ((rowIndex + cellIndex) % 2 === 0) {
			                cell.classList.add('red-bg');
			            } else {
			                cell.classList.add('yellow-bg');
			            }
			        });
			    });
			});
		</script>

	</body>
</html>