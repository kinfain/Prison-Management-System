package com.example.demo.repository.util;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
 
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
 
import static org.springframework.data.jpa.domain.Specifications.where;
 
 
public class WiselyRepositoryImpl<E, PK extends Serializable> extends SimpleJpaRepository<E, PK> implements
    WiselyRepository<E, PK> {
  public final EntityManager entityManager;
 
  public WiselyRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }
 
 
  @SuppressWarnings("deprecation")
  @Override
  public Page<E> queryByExampleWithRange(Example example, List<EntityRange<E>> ranges, Pageable pageable) {
    Specification<E> byExample = new ByExampleSpecification<>(example);
    Specification<E> byRanges = new ByRangeSpecification<>(ranges);
    return findAll(Specification.where(byExample).and(byRanges),pageable);
  }
  
  @SuppressWarnings("deprecation")
  @Override
  public Page<E> queryByExample(Example example, Pageable pageable) {
    Specification<E> byExample = new ByExampleSpecification<>(example);
    return findAll(Specification.where(byExample), pageable);
  }
}