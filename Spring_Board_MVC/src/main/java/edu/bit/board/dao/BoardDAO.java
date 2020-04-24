package edu.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.bit.board.vo.BoardVO;

@Repository("boardDAO") // ("boardDAO") : 생략가능
public class BoardDAO {
	private DataSource dataSource;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String query = "SELECT * FROM Board ORDER BY bGroup DESC, bStep ASC";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");

				BoardVO boardVO = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				boardList.add(boardVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return boardList;
	}

	public int write(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rn = 0;

		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Board (bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (Board_seq.NEXTVAL, ?, ?, ?, SYSDATE, 0, Board_seq.CURRVAL, 0, 0)";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, boardVO.getbName());
			pstmt.setString(2, boardVO.getbTitle());
			pstmt.setString(3, boardVO.getbContent());

			rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rn;
	}

	public BoardVO contentView(BoardVO boardVO) {
		hitUp(boardVO.getbId());

		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String query = "SELECT * FROM Board WHERE bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardVO.getbId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				vo = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return vo;
	}

	private void hitUp(int getbId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String query = "UPDATE BOARD SET bHit = bHit + 1 WHERE bId = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, getbId);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public int delete(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rn = 0;

		try {
			conn = dataSource.getConnection();
			String query = "DELETE FROM Board WHERE bId = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, boardVO.getbId());

			rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rn;
	}

	public BoardVO modifyView(BoardVO boardVO) {
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String query = "SELECT * FROM Board WHERE bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardVO.getbId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				vo = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return vo;
	}

	public int modify(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rn = 0;

		try {
			conn = dataSource.getConnection();
			String query = "UPDATE BOARD SET bTitle = ?, bContent = ?, bDate = SYSDATE WHERE bId = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, boardVO.getbTitle());
			pstmt.setString(2, boardVO.getbContent());
			pstmt.setInt(3, boardVO.getbId());

			rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rn;
	}

	public BoardVO replyView(BoardVO boardVO) {
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String query = "SELECT * FROM Board WHERE bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardVO.getbId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				vo = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return vo;
	}

	public int reply(BoardVO boardVO) {
		replyShape(boardVO);

		Connection conn = null;
		PreparedStatement pstmt = null;
		int rn = 0;

		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Board (bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (Board_seq.NEXTVAL, ?, ?, ?, SYSDATE, 0, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, boardVO.getbName());
			pstmt.setString(2, boardVO.getbTitle());
			pstmt.setString(3, boardVO.getbContent());
			pstmt.setInt(4, boardVO.getbGroup());
			pstmt.setInt(5, boardVO.getbStep() + 1);
			pstmt.setInt(6, boardVO.getbIndent() + 1);
			rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rn;
	}

	private void replyShape(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String query = "UPDATE BOARD SET bStep = bStep + 1 WHERE bGroup = ? AND bStep > ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, boardVO.getbGroup());
			pstmt.setInt(2, boardVO.getbStep());

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
