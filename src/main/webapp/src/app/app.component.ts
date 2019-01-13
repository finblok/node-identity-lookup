import {Component, OnInit} from '@angular/core';
import {NodeLookupService} from "./services/node-lookup.service";
import {NodeIdentity} from "./model/NodeIdentity";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Corda Node Identities';

  nodes : NodeIdentity[];
  loaded : boolean = false;

  constructor(private nodeLookupService : NodeLookupService) {
  }

  ngOnInit() {
    this.loadNicknames();
  }

  loadNicknames() {
    this.nodeLookupService.getAll().subscribe(res => {
      this.nodes = res;
      this.loaded = true;
      console.log(this.nodes);
    });
  }

  updateNickname(node : NodeIdentity, newName : string) {
    this.nodeLookupService.updateNickname(node.cordaX500Name, newName).subscribe(res => {
      this.loaded = false;
      this.loadNicknames();
    });
  }
}
