package com.market.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
public class UsersModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}