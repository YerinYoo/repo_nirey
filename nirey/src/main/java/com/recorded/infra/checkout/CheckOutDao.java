package com.recorded.infra.checkout;

import com.recorded.infra.product.ProductDto;

public interface CheckOutDao {

	public int insertOrders(ProductDto dto);
	public int insertOrderedProd(ProductDto dto);
}
