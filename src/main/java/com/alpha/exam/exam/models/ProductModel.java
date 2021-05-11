package com.alpha.exam.exam.models;

import lombok.Data;

@Data
public class ProductModel {

    //        "id": "5c405847-f1e5-274b-bd5b-d9df7db36bc3",
    //        "price": 456.123456,
    //        "continent": "asia",
    //        "multiplier": 4.123456,
    //        "createdAt": "2021-01-04T00:00:00.123"

    String id;
    Double price;
    String continent;
    Double multiplier;
    String createdAt;
}
