import { Component } from '@angular/core';
import { ChatService } from '../../services/chat.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ram',
  imports: [CommonModule],
  templateUrl: './ram.component.html',
  styleUrl: './ram.component.css'
})
export class RamComponent {
  name:string="Ram";

  constructor(public cs:ChatService){

  }

  sendMessage(msg:string){
    this.cs.chatMessage(this.name+": "+msg);
  }

}
