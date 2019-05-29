import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  public API = "http://backend:8080"
  public ITEM_API = this.API + '/items'
  constructor(private http: HttpClient) { }

  getAllItem(): Observable<any> {
    return this.http.get('http://backend:8080/items')
  }

  getItem(id: string) {
    return this.http.get(this.ITEM_API + '/' + id)
  }

  save(item: any): Observable<any> {
    let result: Observable<Object>
    if (item['href']) {
      result = this.http.put(item.href, item)
    } else {
      result = this.http.post(this.ITEM_API, item)
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href)
  }

}
