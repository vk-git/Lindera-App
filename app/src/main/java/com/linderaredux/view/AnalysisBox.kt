package com.linderaredux.view

import android.content.Context
import android.graphics.PorterDuff
import android.text.Html
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.linderaredux.R
import com.linderaredux.api.response.PatientType
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.extensions.gone
import com.linderaredux.extensions.visible
import com.linderaredux.utils.DateUtils

class AnalysisBox : LinearLayout {

    private lateinit var layout_date: LinearLayout
    private lateinit var txtLastAnalysisLabel: TextView
    private lateinit var txtLastAnalysisDate: TextView
    private lateinit var txtPatientName: TextView
    private lateinit var patientScoreMsg: TextView
    private lateinit var txtLastAnalysisDate1: TextView
    private lateinit var txtAnalysisStatus1: TextView
    private lateinit var imgStatus1: ImageView
    private lateinit var txtAnalysisStatus2: TextView
    private lateinit var imgStatus2: ImageView
    private lateinit var btnAnalysis: TextView
    private lateinit var slideImg: ImageView
    private lateinit var patientScore: CircularProgressIndicator

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs, android.R.attr.textStyle)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.analysisbox, this)

        layout_date = findViewById(R.id.layout_date)
        txtLastAnalysisLabel = findViewById(R.id.txtLastAnalysisLabel)
        txtLastAnalysisDate = findViewById(R.id.txtLastAnalysisDate)
        txtPatientName = findViewById(R.id.txtPatientName)
        patientScore = findViewById(R.id.patientScore)
        patientScoreMsg = findViewById(R.id.patientScoreMsg)
        txtLastAnalysisDate1 = findViewById(R.id.txtLastAnalysisDate1)
        txtAnalysisStatus1 = findViewById(R.id.txtAnalysisStatus1)
        imgStatus1 = findViewById(R.id.imgStatus1)
        txtAnalysisStatus2 = findViewById(R.id.txtAnalysisStatus2)
        imgStatus2 = findViewById(R.id.imgStatus2)
        slideImg = findViewById(R.id.slideImg)
        btnAnalysis = findViewById(R.id.btnAnalysis)
    }

    fun setPatient(patientType: PatientType, patient: Patient) {
        val hasOfflineVideo = false
        if (patientType === PatientType.ARCHIVE && patient.analyse!!.isNotEmpty()) {
            txtLastAnalysisDate1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_date))
            slideImg.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP)
            layout_date.visibility = View.GONE
            txtPatientName.text = "${patient.firstname} ${patient.lastname}"
            //val patientScoreInt = getPatientScore(patient)
            val patientScoreInt = -1
            if (patientScoreInt != -1) {
                patientScore.visible()
            } else {
                patientScore.gone()
                patientScoreMsg.text = "Coming Soon\nfall probability"
            }

            if(patient.analyse!!.isNotEmpty()) {
                val timeStamp = patient.analyse[patient.analyse.size - 1].timestamp!!.substring(0, 10)
                txtLastAnalysisDate1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_date, timeStamp))
            }

            if (patient.analyse[patient.analyse.size - 1].answerQuestionnaireID != null && patient.analyse[patient.analyse.size - 1].videoID != null && patient.analyse[patient.analyse.size - 1].submittedByUser) {
                txtAnalysisStatus1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status1, "Completed"))
                imgStatus1.setImageResource(R.drawable.check_ok)
            } else if (patient.analyse[patient.analyse.size - 1].answerQuestionnaireID == null) {
                txtAnalysisStatus1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status1, "Questionnaire not done yet"))
                imgStatus1.setImageResource(R.drawable.questions_missing)
            }

            if (patient.analyse[patient.analyse.size - 1].videoID == null) {
                if (hasOfflineVideo) {
                    txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "has offline data"))
                    imgStatus2.setImageResource(R.drawable.video_missing)
                } else {
                    txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "Video not recorded"))
                    imgStatus2.setImageResource(R.drawable.video_missing)
                }
            } else if (patient.analyse[patient.analyse.size - 1].answerQuestionnaireID != null && patient.analyse[patient.analyse.size - 1].videoID != null && !patient.analyse[patient.analyse.size - 1].submittedByUser) {
                txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "Request analyse  now"))
                imgStatus2.setImageResource(R.drawable.questions_missing)
            }

            if (patient.analyse[patient.analyse.size - 1].submittedByUser) {
                btnAnalysis.text = "Repeat analysis"
            } else {
                btnAnalysis.text = "Continue Analyse"
            }
        } else if (patientType === PatientType.UPLOAD) {
            if(patient.analyse!![patient.analyse.size-1].answerQuestionnaireID!=null) {
                val timeStamp = patient.analyse[patient.analyse.size - 1].timestamp!!.substring(0, 10)
                txtLastAnalysisDate1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_date, timeStamp))
            }

            if (patient.analyse[patient.analyse.size - 1].answerQuestionnaireID != null) {
                txtLastAnalysisDate.text = patient.analyse[patient.analyse.size - 1].timestamp
            }

            txtAnalysisStatus1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status1, "has offline data"))
            imgStatus1.visibility = View.GONE
            imgStatus2.visibility = View.GONE

            if (!patient.analyse[patient.analyse.size - 1].answerQuestionnaireID.isNullOrEmpty()) {
                txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "Questionnaire not done yet"))
            }

            btnAnalysis.text = "Upload"

        } else if (patientType === PatientType.PROGRESS) {
            txtLastAnalysisDate1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_date, DateUtils.getDateTime()))
            slideImg.setColorFilter(ContextCompat.getColor(context, R.color.medium_grey), PorterDuff.Mode.SRC_ATOP)
            layout_date.visibility = View.GONE
            txtPatientName.text = "${patient.firstname} ${patient.lastname}"
            patientScore.visibility = View.GONE
            patientScoreMsg.visibility = View.GONE

            if (patient.analyse!![patient.analyse.size - 1].answerQuestionnaireID == null) {
                txtAnalysisStatus1.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status1, "Questionnaire not done yet"))
                imgStatus1.setImageResource(R.drawable.questions_missing)
            }

            if (patient.analyse[patient.analyse.size - 1].videoID == null) {
                if (hasOfflineVideo) {
                    txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "has offline data"))
                    imgStatus2.setImageResource(R.drawable.video_missing)
                } else {
                    txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "Video not recorded"))
                    imgStatus2.setImageResource(R.drawable.video_missing)
                }
            } else if (patient.analyse[patient.analyse.size - 1].answerQuestionnaireID != null && patient.analyse[patient.analyse.size - 1].videoID != null && !patient.analyse[patient.analyse.size - 1].submittedByUser) {
                txtAnalysisStatus2.text = Html.fromHtml(resources.getString(R.string.dashboard_progress_status2, "Request analyse  now"))
                imgStatus2.setImageResource(R.drawable.questions_missing)
            }

            if (patient.analyse[patient.analyse.size - 1].answerQuestionnaireID != null && patient.analyse[patient.analyse.size - 1].videoID != null && !patient.analyse[patient.analyse.size - 1].submittedByUser) {
                btnAnalysis.text = "Submit"
            } else {
                btnAnalysis.text = "Complete"
            }
        }
    }

    private fun getPatientScore(tempPatient: Patient): Int {
        if (tempPatient.analyse!!.isNotEmpty()) {
            if (tempPatient.analyse[tempPatient.analyse.size - 1].score != null && tempPatient.analyse[tempPatient.analyse.size - 1].submittedByUser) {
                return tempPatient.analyse[tempPatient.analyse.size - 1].score as Int
            } else if (tempPatient.analyse[tempPatient.analyse.size - 2] != null) {
                if (tempPatient.analyse[tempPatient.analyse.size - 2].score != null) {
                    return tempPatient.analyse[tempPatient.analyse.size - 2].score as Int
                }
            }
        }
        return -1
    }
}
