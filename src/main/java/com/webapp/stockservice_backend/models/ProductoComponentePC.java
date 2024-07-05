package com.webapp.stockservice_backend.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Component")
public class ProductoComponentePC extends Producto {

}
