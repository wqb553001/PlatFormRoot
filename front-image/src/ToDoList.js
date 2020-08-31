import React from 'react';

import ToDoItem from './ToDoItem';  //����ToDoItemģ��
class ToDoList extends React.Component{
    render(){
        let todos=this.props.data;
        let todoItems=todos.map(item=>{
            return <ToDoItem okItem={this.props.okItem} deleteItem={this.props.deleteItem} key={item.id} data={item}/>
        });

        return (
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>����</th>
                    <th>ʱ��</th>
                    <th>״̬</th>
                    <th>����</th>
                </tr>
                </thead>
                <tbody>
                {todoItems}
                </tbody>
            </table>
        );
    }
}

export default ToDoList;  //����ToDoListģ��