create table ChessDB
(
 moves smallint(5)
 games smallint(5)
);

select count(moves) from ChessDB;
select count(games) from ChessDB;
-------------------------------------------
//*
//Above code is for MySQL in NetBeans. Table is created with columns which store number of moves and number of games
//Two select statements are used to show the count for number of moves and number of games stored in database
//Statements are written separate to better distinguish the two values
*//
try{								//*Try-catch method used to find exceptions. The purpose of the contents of the try part is to count the
								number of moves and store them into the database*//
	chessBoard.mouseClicked("com.mysql.jdcb.Driver");
	Connection conn = DriverManager.getConnection("jdcb:mysql://localhost:3306/ChessDB","root","**insert password**");

	String sql = "insert into ChessDB (moves) value (1)";
	
}catch(Exception e)
{
	JOptionPane.showMessageDialog(null, e);
}

try{								//*Similarly to above, the try part here instead counts the number of times the program is closed and
								stores this information to the database. This serves as a game counter*//
	GUIFrame.setDefaultCloseOperator("com.mysql.jdcb.Driver");
	Connection conn = DriverManager.getConnection("jdcb:mysql://localhost:3306/ChessDB","root","**insert password**");

	String sql = "insert into ChessDB (games) value (1)";
	
}catch(Exception e)
{
	JOptionPane.showMessageDialog(null, e);
}