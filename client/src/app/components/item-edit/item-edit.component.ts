import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { ItemService } from '../../service/item/item.service';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit, OnDestroy {
  
  item: any = {}
  sub: Subscription;
  
  constructor(private route: ActivatedRoute,
              private router: Router,
              private itemService: ItemService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.itemService.getItem(id).subscribe((item: any) => {
          if (item) {
            this.item = item;
            this.item.href = item._links.self.href
          } else {
            console.log('${id}' + ' not found')
            this.toList()
          }
        })
      }
    })
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  toList() {
    this.router.navigate(['/items'])
  }

  save(form: NgForm) {
    this.itemService.save(form).subscribe(result => {
      this.toList();
    }, error => {
      console.error(error)
    })
  }

  remove(href) {
    this.itemService.remove(href).subscribe(result => {
      this.toList()
    }, error => {
      console.error(error)
    })
  }

}
