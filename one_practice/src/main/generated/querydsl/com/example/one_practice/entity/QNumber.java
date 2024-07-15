package com.example.one_practice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNumber is a Querydsl query type for Number
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNumber extends EntityPathBase<Number> {

    private static final long serialVersionUID = -307239701L;

    public static final QNumber number = new QNumber("number");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath role = createString("role");

    public QNumber(String variable) {
        super(Number.class, forVariable(variable));
    }

    public QNumber(Path<? extends Number> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNumber(PathMetadata metadata) {
        super(Number.class, metadata);
    }

}

