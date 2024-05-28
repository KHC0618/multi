package com.multi.shop.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.multi.shop.member.model.dto.MemberDTO;
import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/product/update")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDTO product;
		String path = "";
		
		try {
			product = productService.selectProduct(id);
			ArrayList<CompanyDTO> companyList = productService.selectCompanyList();

			request.setAttribute("product", product);
			request.setAttribute("companyList", companyList);
			
			path = "/WEB-INF/views/product/updateform.jsp";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";

			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";

			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);

			if (!directory.exists() || !directory2.exists()) {
				directory.mkdirs();
				directory2.mkdirs();
			}

			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();

			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);

			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			String path = "";

			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);

				for (FileItem item : fileItems) {
					if (!item.isFormField()) {
						if (item.getSize() > 0) {
							String filedName = item.getFieldName();
							String originFileName = item.getName();

							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);

							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;

							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							item.write(storeFile);

							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);

							int width = 0;
							int height = 0;
							if ("thumbnailImg1".equals(filedName)) {
								fileMap.put("fileType", "TITLE");
								width = 350;
								height = 200;
							} else {
								fileMap.put("fileType", "BODY");
								width = 120;
								height = 100;
							}

							Thumbnails.of(fileUploadDirectory + randomFileName).size(width, height)
									.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);

							fileList.add(fileMap);
						}
					} else {
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					}
				}

				int id = Integer.parseInt(parameter.get("id"));
				String name = parameter.get("name");
				String content = parameter.get("content");
				String modifyPerson = ((MemberDTO) request.getSession().getAttribute("loginMember")).getId();
				String companyId = parameter.get("company");
				int price = Integer.parseInt(parameter.get("price"));

				ProductDTO updatedProduct = new ProductDTO();
				updatedProduct.setId(id);
				updatedProduct.setName(name);
				updatedProduct.setContent(content);
				updatedProduct.setPrice(price);
				updatedProduct.setModifyPerson(modifyPerson);

				CompanyDTO company = new CompanyDTO();
				company.setId(companyId);

				updatedProduct.setCompany(company);
				updatedProduct.setAttachments(new ArrayList<AttachmentDTO>());

				List<AttachmentDTO> list = updatedProduct.getAttachments();
				for (Map<String, String> file : fileList) {
					AttachmentDTO tempFileInfo = new AttachmentDTO();
					tempFileInfo.setOriginalName(file.get("originFileName"));
					tempFileInfo.setSavedName(file.get("savedFileName"));
					tempFileInfo.setSavePath(file.get("savePath"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					tempFileInfo.setCreatePerson(modifyPerson);
					list.add(tempFileInfo);
				}

				// Delete old files
				ProductDTO oldProduct = productService.selectProduct(id);
				List<AttachmentDTO> oldFiles = oldProduct.getAttachments();
				for (AttachmentDTO oldFile : oldFiles) {
					File deleteFile = new File(oldFile.getSavePath() + "/" + oldFile.getSavedName());
					deleteFile.delete();
				}

				int result = productService.updateProduct(updatedProduct);

				if (result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "updateProduct");
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "제품 수정 실패!");
				}

			} catch (Exception e) {
				for (Map<String, String> file : fileList) {
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					deleteFile.delete();
				}
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "제품 수정 실패!");
				e.printStackTrace();
			}

			request.getRequestDispatcher(path).forward(request, response);
		}
	}
}
