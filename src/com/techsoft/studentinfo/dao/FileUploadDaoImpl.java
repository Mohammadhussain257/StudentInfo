package com.techsoft.studentinfo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techsoft.studentinfo.dto.FileDTO;
import com.techsoft.studentinfo.util.DbUtil;


public class FileUploadDaoImpl implements FileUploadDao {

	public void saveFileInfo(FileDTO fileDto) {
		PreparedStatement ps = null;
		try {
			String sql = "insert into file_info(file_name,file_path,description)values(?,?,?)";
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, fileDto.getFilePath());
			ps.setString(2, fileDto.getFileName());
			ps.setString(3, fileDto.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<FileDTO> listFile() {
		List<FileDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			String sql = "select * from file_info";
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setId(rs.getInt("id"));
				fileDTO.setFileName(rs.getString("file_name"));
				fileDTO.setFilePath(rs.getString("file_path"));
				fileDTO.setDescription(rs.getString("description"));
				list.add(fileDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public FileDTO getFileInfoById(int id) {
		FileDTO fileDTO = new FileDTO();
		PreparedStatement ps = null;
		try {
			String sql = "select * from file_info where id=?";
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fileDTO.setId(rs.getInt("id"));
				fileDTO.setFileName(rs.getString("file_name"));
				fileDTO.setFilePath(rs.getString("file_path"));
				fileDTO.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fileDTO;
	}
}
