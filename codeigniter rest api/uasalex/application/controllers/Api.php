<?php
defined('BASEPATH') OR exit('No direct script access allowed');

use chriskacerguis\RestServer\RestController;

class Api extends RestController {

	public $tanaman;

	public function __construct()
	{

		parent::__construct();
		$this->load->model('Model_tanaman', 'tanaman');
	}

	public function tanaman_get()
	{
		$getData =  $this->tanaman->get_data();
		if($getData->num_rows() !=0 ){
			$data = [
				'status' => 'berhasil',
				'result' => $getData->result_array(),
				'message' => 'Data berhasil didapatkan'
			];
			$this->response($data, 200);
		}else {
			$this->response([
				'status' => 'gagal',
				'result' => [],
				'message' => 'data kosong!'
			], 404);
		}
	}
}
