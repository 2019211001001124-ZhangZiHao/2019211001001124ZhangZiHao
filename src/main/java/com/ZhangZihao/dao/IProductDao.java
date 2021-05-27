package com.ZhangZihao.dao;

import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.Product;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;



public interface IProductDao {
	/**
	 * Insert a product
	 * @return int
	 */
	public int save(Product product, Conn con) throws SQLException;
	/**
	 * Delete a product by productId
	 * @return int
	 */
	public int delete(Integer productId, Conn con) throws SQLException;
	/**
	 *	Update a product by productId
	 * @return int
	 */
	public int update(Product instance, Conn con) throws SQLException;
	/**
	 *	Select a product by productId
	 * @return Product model
	 */
	public Product findById(Integer productId, Conn con) throws SQLException;
	/**
	 * Select all product by categoryId
	 * @param categoryId
	 * @return List of product
	 */
	public List<Product> findByCategoryId(int categoryId, Conn con) throws SQLException;
	/**
	 * Select product by price between minprice and maxPrice
	 * @return List of product
	*/
	public List<Product> findByPrice(double minPrice, double maxPrice,Conn con) throws SQLException;
	/**
	 * Find all products
	 * @return List of product
	 */
	public List<Product> findAll(Conn con) throws SQLException;
	/**
	 * Select all product by name like
	 * @return List of product
	 */
	public List<Product> findByProductName(String productName, Conn con) throws SQLException;
	/**
	 * Select all product by name like
	 * @return List of product
	 */
	public InputStream getPicture(Integer productId, Conn con) throws SQLException;
}
