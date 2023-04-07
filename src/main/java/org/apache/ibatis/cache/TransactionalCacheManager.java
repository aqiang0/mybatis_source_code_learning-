/*
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.cache;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.cache.decorators.TransactionalCache;
import org.apache.ibatis.util.MapUtil;

/**
 * @author Clinton Begin
 */
public class TransactionalCacheManager {

  // 二级缓存池，一个mapper作为一个entity，key=命名空间，value=TransactionalCache
  // TransactionalCache中delegate属性是具体的缓存值，该cache也是一个map，key=为cacheKey对象，value为具体缓存值
  private final Map<Cache, TransactionalCache> transactionalCaches = new HashMap<>();

  public void clear(Cache cache) {
    getTransactionalCache(cache).clear();
  }

  public Object getObject(Cache cache, CacheKey key) {
    return getTransactionalCache(cache).getObject(key);
  }

  // cache：标识当前namespace，cacheKey：标识当前SQL，value：查询的值
  public void putObject(Cache cache, CacheKey key, Object value) {
    // 这里cache通过命名空间标识，方法1获取到某一命名空间下的缓存，这里是cache.id=my.mapper.UserMapper
    // 方法2把查询值放到待提交的缓存中
    // 整个put的流程，1、通过MappedStatement获取到二级缓存唯一标识cache，这个cache是在解析mapper.xml的时候就注入进去了
    // 2、通过cache获取到TransactionalCache，把结果放入待提交缓存即entriesToAddOnCommit
    getTransactionalCache(cache).putObject(key, value);
  }

  public void commit() {
    // 什么时候调用呢？在sqlSession.close()调用时
    for (TransactionalCache txCache : transactionalCaches.values()) {
      txCache.commit();
    }
  }

  public void rollback() {
    for (TransactionalCache txCache : transactionalCaches.values()) {
      txCache.rollback();
    }
  }

  private TransactionalCache getTransactionalCache(Cache cache) {
    return MapUtil.computeIfAbsent(transactionalCaches, cache, TransactionalCache::new);
  }

}
