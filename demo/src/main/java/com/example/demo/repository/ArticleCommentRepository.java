package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.domain.ArticleComment;
import com.example.demo.domain.QArticle;
import com.example.demo.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;

@RepositoryRestResource
public interface ArticleCommentRepository extends
	JpaRepository<ArticleComment, Long>,
	QuerydslPredicateExecutor<ArticleComment>,
	QuerydslBinderCustomizer<QArticleComment> {
	@Override
	default void customize(QuerydslBindings bindings, QArticleComment root){
		bindings.excludeUnlistedProperties(true);
		bindings.including(root.content,root.createdAt,root.createdBy);
		// bindings.bind(root.title).first(StringExpression::likeIgnoreCase); // like '${v}'
		bindings.bind(root.content).first(StringExpression::containsIgnoreCase);// like '%${v}%'
		bindings.bind(root.createdAt).first(DateTimeExpression::eq);
		bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
	}
}