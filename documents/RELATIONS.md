# RELATIONS

|Relation|Annotation|MARKS|
|:---|:---|:---|
|1 vs 1|@OneToOne||
|1 vs n|@OneToMany|fetch, mappedBy|
|n vs 1|@ManyToOne|type change|
|n vs n|@ManyToMany||

- Fetch type: LAZY = 지연(1:n), EAGER = 즉시(1:1)

- @ToString: 연관 관계 설정 변수 exclude

### Workbench

- Database -> Reverse Engineer -> Forward Engineer