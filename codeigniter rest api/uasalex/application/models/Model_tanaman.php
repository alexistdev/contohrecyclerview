<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Model_tanaman extends CI_Model
{

	public function __construct()
	{
		parent::__construct();
		$this->tableTanaman = 'tanaman';
	}

	public function get_data()
	{
		return $this->db->get($this->tableTanaman);
	}
}
