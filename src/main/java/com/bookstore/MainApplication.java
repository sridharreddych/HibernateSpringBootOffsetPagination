package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
/*
 * 
 * 
 * 
 * 
 * How To Implement Offset Pagination in Spring Boot

Description: This is a regular Spring Boot offset pagination example. However, is not advisable to use this approach in production because of its performance penalties explained further.

When we rely on an offset pagination, we have the performance penalty induced by throwing away n records before reaching the desired offset. Larger n leads to a significant performance penalty. Another penalty is the extra-SELECT needed to count the total number of records. In order to understand how bad offset pagination can perform please check this article. A screenshot from that article is below:  Nevertheless, maybe this example is a little bit extreme. For relatively small datasets, offset pagination is not so bad (it is close in performance to keyset pagination), and, since Spring Boot provides built-in support for offset pagination via the Page API, it is very easy to use it. However, depending on the case, we can optimize a little bit the offset pagination as in the following examples:

Fetch a page as a Page:

Trigger COUNT(*) OVER And Return Page<dto>
Trigger COUNT(*) OVER And Return Page<entity> Via Extra Column
Trigger SELECT COUNT Subquery And Return Page<dto>
Trigger SELECT COUNT Subquery And Return Page<entity> Via Extra Column
Trigger SELECT COUNT Subquery And Return Page<projection> That Maps Entities And The Total Number Of Records Via Projection
Fetch a page as a List:

Trigger COUNT(*) OVER And Return List<dto>
Trigger COUNT(*) OVER And Return List<entity> Via Extra Column
Trigger SELECT COUNT Subquery And Return List<dto>
Trigger SELECT COUNT Subquery And Return List<entity> Via Extra Column
Trigger SELECT COUNT Subquery And Return List<projection> That Maps Entities And The Total Number Of Records Via Projection
But: If offset pagination is causing you performance issues and you decide to go with keyset pagination then please check here (keyset pagination).

Key points of classical offset pagination:

write a repository that extends PagingAndSortingRepository
call or write methods that returns Page<entity>
Examples of classical offset pagination:

call the built-in findAll(Pageable) without sorting:
repository.findAll(PageRequest.of(page, size));
call the built-in findAll(Pageable) with sorting:
repository.findAll(PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "name")));
use Spring Data query creation to define new methods in your repository:
Page<Author> findByName(String name, Pageable pageable);
Page<Author> queryFirst10ByName(String name, Pageable pageable);
 */
